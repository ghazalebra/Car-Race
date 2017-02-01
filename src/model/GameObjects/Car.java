package model.GameObjects;

import model.GameEngine;

import java.util.Date;
import java.util.List;
import java.util.TimerTask;

/**
 * Created by ASUS on 08/12/2016.
 */
public class Car extends TimerTask {


    private Street currentStreet;
    private CarProfile carProfile;
    private Point startPoint;
    private Point currentLocationPoint;
    private double acceleration;
    private Vector primarySpeed;//i think it is assumed to be zero, but i'm not sure.
    private Vector currentSpeed;
    private double startTime;//time the car begins moving.
    private double currentTime;
    private boolean brakeIsPressed;
    private boolean isTurningLeft;
    private boolean isTurningRight;
    private Point frontRight;
    private Point frontLeft;
    private Point rearRight;
    private Point rearLeft;
    private boolean gasPedalIsPressed;
    private Vector perpendicularSpeed;
    private boolean isActive;
    private List<Intersection> visitedIntersections;
    private Match match;
    private Player player;
    private int roundNumberCounter;
    private double RealMatchRecord;


    //constructor
    public Car(CarProfile carProfile, Point startPoint, Vector primarySpeed){
        this.carProfile = carProfile;
        this.startPoint = startPoint;
        this.currentLocationPoint = startPoint;
        this.primarySpeed = primarySpeed;
        setPrimaryFrontLeft(startPoint);
        setPrimaryFrontRight(startPoint);
        setPrimaryRearLeft(startPoint);
        setPrimaryRearRight(startPoint);
    }

    //setters and getters


    public List<Intersection> getVisitedIntersections() {
        return visitedIntersections;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Vector getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(Vector currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public Vector getPrimarySpeed() {
        return primarySpeed;
    }

    public void setPrimarySpeed(Vector primarySpeed) {
        this.primarySpeed = primarySpeed;
    }

    public double getStartTime() {
        return startTime;
    }

    public double getCurrentTime() {
        return currentTime;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(double acceleration) { this.acceleration = acceleration; }

    public CarProfile getCarProfile() {
        return carProfile;
    }

    public void setPerpendicularSpeed(Vector currentSpeed) {
         perpendicularSpeed = new Vector(0, currentSpeed.getalpha() - 90);
    }

    public Vector getPerpendicularSpeed() {
        return perpendicularSpeed;
    }

    public void setBrakeIsPressed(boolean brakeIsPressed) {
        this.brakeIsPressed = brakeIsPressed;
    }

    public Point getFrontRight() { return frontRight; }

    public Point getFrontLeft() {
        return frontLeft;
    }

    public Point getRearRight() {
        return rearRight;
    }

    public Point getRearLeft() { return rearLeft; }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public int getRoundNumberCounter() {
        return roundNumberCounter;
    }

    public void setRoundNumberCounter(int roundNumberCounter) {
        this.roundNumberCounter = roundNumberCounter;
    }

    //end of getters and setters!! :)


    //Maybe should be somewhere else:?
    public double formula(double x, Point point1, Point point2){
        double m = (point2.getY() - point1.getY()) / (point2.getX() - point1.getX());
        return m * (x - point1.getX()) + point1.getY();
    }

    //these methods will be only called in constructor.
    public void setPrimaryFrontRight(Point currentLocationPoint){
        frontRight = new Point(currentLocationPoint.getX() + carProfile.getWidth()/2,
                currentLocationPoint.getY() + carProfile.getLength()/2);
    }

    public void setPrimaryRearRight(Point currentLocationPoint){
        rearRight = new Point(currentLocationPoint.getX() + carProfile.getWidth()/2,
                currentLocationPoint.getY() - carProfile.getLength()/2);
    }

    public void setPrimaryFrontLeft(Point currentLocationPoint){
        frontLeft = new Point(currentLocationPoint.getX() - carProfile.getWidth()/2,
                currentLocationPoint.getY() + carProfile.getLength()/2);
    }

    public void setPrimaryRearLeft(Point currentLocationPoint){
        rearLeft = new Point(currentLocationPoint.getX() - carProfile.getWidth()/2,
                currentLocationPoint.getY() - carProfile.getLength()/2);
    }

    //Brake
    public boolean BrakeIsPressed() {
        return brakeIsPressed;
    }

    public void pressBrake(){
        this.setBrakeIsPressed(true);
        acceleration -= carProfile.getBrakeAcceleration();
    }

    public void releaseBreak(){
        this.setBrakeIsPressed(false);
        acceleration += carProfile.getBrakeAcceleration();
    }

    //Gas pedal
    public boolean GasPedalIsPressed() {
        return gasPedalIsPressed;
    }

    public void pressGasPedal(){
        gasPedalIsPressed = true;
        acceleration += carProfile.getEngine().getEngineAcceleration();
    }

    public void releaseGasPedal(){
        gasPedalIsPressed = false;
        acceleration -= carProfile.getEngine().getEngineAcceleration();
    }

    //Turning
    public void pressRightTurnButton(){
        isTurningRight = true;
    }

    public void pressLeftTurnButton(){
        isTurningLeft = true;
    }

    public void releaseRightTurnButton(){
        isTurningRight = false;
    }

    public void releaseLeftTurnButton(){
        isTurningLeft = false;
    }

    //returns the radius of its circular path.
    public double radiusOfTurn(){
        return (carProfile.getWeight()*Math.pow(currentSpeed.getMagnitude(), 2))/carProfile.getSteeringWheelPower();
    }

    //updates the location point while turning.
    public Point turningLocation(Point point){
        Point center;
        double turningSpeed= currentSpeed.getMagnitude();
        if(isTurningRight) {
            Vector radius = new Vector(radiusOfTurn(), currentSpeed.getalpha()-90);
            double x = point.getX()+radius.getX();
            double y = point.getY()+radius.getY();
            center = new Point(x, y);
            double Omega = currentSpeed.getMagnitude()/radiusOfTurn();
            Vector initialLocation= new Vector(center, point);
            Vector finalLocation= new Vector(radiusOfTurn(), initialLocation.getalpha() + Omega);
            return finalLocation.endPoint;
        }
        else if (isTurningLeft){
            Vector radius = new Vector(radiusOfTurn(), currentSpeed.getalpha()+90);
            double x = point.getX()+radius.getX();
            double y = point.getY()+radius.getY();
            center = new Point(x, y);
            double Omega = currentSpeed.getMagnitude()/radiusOfTurn();
            Vector initialLocation= new Vector(center, point);
            Vector finalLocation= new Vector(radiusOfTurn(), initialLocation.getalpha() - Omega);
            return finalLocation.endPoint;
        }
        return new Point(0, 0);
    }

    //Collision
    //Wall collision
    public boolean isCollisionOccurred(){
        if (currentStreet.getLines().get(0).direction.equals(Direction.UP) || currentStreet.getLines().get(0).direction.equals(Direction.DOWN)){
            if (currentLocationPoint.getX() > currentStreet.getEnd().getPoint2().getX() ||
                    currentLocationPoint.getX() < currentStreet.getEnd().getPoint1().getX())
                return true;
        }

        if (currentStreet.getLines().get(0).direction.equals(Direction.LEFT) || currentStreet.getLines().get(0).direction.equals(Direction.RIGHT)){
            if (currentLocationPoint.getY() < currentStreet.getEnd().getPoint4().getY() ||
                    currentLocationPoint.getY() > currentStreet.getEnd().getPoint1().getY())
                return true;
        }

        return false;
    }

    public void collision(){
        double primaryKineticEnergy = Math.pow(currentSpeed.getMagnitude(), 2) * carProfile.getWeight() * (1/2);
        carProfile.setBodyPower(carProfile.getBodyPower() - (3/4) * primaryKineticEnergy);
        currentSpeed.setMagnitude(currentSpeed.getMagnitude()/2);
        currentSpeed.setalpha(180 - currentSpeed.getalpha());
    }

    //Update
    public Point updateLocation(Point point){
        if(isTurningLeft || isTurningRight){
            point = turningLocation(point);
            if (perpendicularSpeed.getMagnitude() != 0){
                //vertical friction is negative.
                double d = (1/2) * (carProfile.getVerticalFriction()/carProfile.getWeight()) + perpendicularSpeed.getMagnitude();
                point.setX(point.getX() + d * Math.cos(currentSpeed.getalpha() - 90));
                point.setY(point.getY() + d * Math.cos(180 - currentSpeed.getalpha()));
                perpendicularSpeed.setMagnitude(perpendicularSpeed.getMagnitude() + carProfile.getVerticalFriction() / carProfile.getWeight());
            }
        }
        else{
            double d = (1/2) * acceleration + currentSpeed.getMagnitude();
            point.setX(point.getX() + d*Math.cos(currentSpeed.getalpha()));
            point.setY(point.getY() + d*Math.sin(currentSpeed.getalpha()));
        }

        return point;
    }

    public void updateStreet(){
        if (currentStreet == null){
            for (int i = 0; i < currentStreet.getEnd().streets.size(); i++){
                if (currentStreet.getEnd().streets.get(i).streetLowerBound(currentLocationPoint.getX())<currentLocationPoint.getY()
                        &&currentLocationPoint.getY()<currentStreet.getEnd().streets.get(i).streetUpperBound(currentLocationPoint.getX())
                        &&((currentLocationPoint.getY()<currentStreet.getEnd().streets.get(i).getLines().get(0).getEndSide().sideFormula(currentLocationPoint.getX())
                        && currentLocationPoint.getY() > currentStreet.getEnd().streets.get(i).getLines().get(0).getStartSide().sideFormula(currentLocationPoint.getX())
                        || (currentLocationPoint.getY()<currentStreet.getEnd().streets.get(i).getLines().get(0).getStartSide().sideFormula(currentLocationPoint.getX())
                        && currentLocationPoint.getY() > currentStreet.getEnd().streets.get(i).getLines().get(0).getEndSide().sideFormula(currentLocationPoint.getX()))))){
                    currentStreet = currentStreet.getEnd().streets.get(i);
                }

            }
            for (int i = 0; i < currentStreet.getStart().streets.size(); i++){
                if (currentStreet.getStart().streets.get(i).streetLowerBound(currentLocationPoint.getX())<currentLocationPoint.getY()
                        &&currentLocationPoint.getY()<currentStreet.getStart().streets.get(i).streetUpperBound(currentLocationPoint.getX())
                        &&((currentLocationPoint.getY()<currentStreet.getStart().streets.get(i).getLines().get(0).getEndSide().sideFormula(currentLocationPoint.getX())
                        && currentLocationPoint.getY() > currentStreet.getStart().streets.get(i).getLines().get(0).getStartSide().sideFormula(currentLocationPoint.getX())
                        || (currentLocationPoint.getY()<currentStreet.getStart().streets.get(i).getLines().get(0).getStartSide().sideFormula(currentLocationPoint.getX())
                        && currentLocationPoint.getY() > currentStreet.getStart().streets.get(i).getLines().get(0).getEndSide().sideFormula(currentLocationPoint.getX()))))){
                    currentStreet = currentStreet.getStart().streets.get(i);
                }
            }
        }
        else if (currentStreet.getEnd().side3T04Formula(currentLocationPoint.getX()) <= currentLocationPoint.getY()
                && currentLocationPoint.getY() <= currentStreet.getEnd().side1T02Formula(currentLocationPoint.getX())
                && currentStreet.getEnd().side2T04Formula(currentLocationPoint.getX()) <= currentLocationPoint.getY()
                && currentLocationPoint.getY() <= currentStreet.getEnd().side1T03Formula(currentLocationPoint.getX())){
            currentStreet = null;
        }

        if (currentStreet.getStart().side3T04Formula(currentLocationPoint.getX()) <= currentLocationPoint.getY()
                && currentLocationPoint.getY() <= currentStreet.getStart().side1T02Formula(currentLocationPoint.getX())
                && currentStreet.getStart().side2T04Formula(currentLocationPoint.getX()) <= currentLocationPoint.getY()
                && currentLocationPoint.getY() <= currentStreet.getStart().side1T03Formula(currentLocationPoint.getX())){
            currentStreet = null;
        }
    }

    public void updateSpeed(){
        double magnitude = currentSpeed.getMagnitude() + acceleration;
        currentSpeed.setMagnitude(Math.abs(magnitude));
        if (magnitude < 0)
            currentSpeed.invert();
    }

    //should be called each millisecond.

    public void StraightTimeMatchIsFinishedTime(){
        if (visitedIntersections.size() == match.getPath().intersections.size()){

            Node node = new Node(currentTime, "Straight");
            player.getPlayerProfile().getRecordsPerMatch().add(node);
        }
    }

    public void CircularTimeMatchIsFinishedTime(){

        while (roundNumberCounter <= match.getRoundNumber()){
            if (visitedIntersections.size() == 1 + (roundNumberCounter + 1) * match.getPath().intersections.size()) {
                if (roundNumberCounter != 0){
                    Node2 node = new Node2(currentTime - player.getPlayerProfile().getRecordsPerRound().get(player.getPlayerProfile().getRecordsPerRound().size() - 1).totalTime, currentTime);
                    player.getPlayerProfile().getRecordsPerRound().add(node);
                }
                else{
                    Node2 node = new Node2(currentTime, currentTime);
                    player.getPlayerProfile().getRecordsPerRound().add(node);
                }
            }
        }
    }

    public void timeFinishedStraightRealRace(){
        if (this.visitedIntersections.size() == match.getPath().getIntersections().size()) {
            RealMatchRecord = currentTime;
            match.getOrderOfCars().add(this);
        }
    }

    public void timeFinishedCircularRealRace(){
        if (this.visitedIntersections.size() == match.getRoundNumber() * match.getPath().getIntersections().size() + 1) {
            RealMatchRecord = currentTime;
            match.getOrderOfCars().add(this);
        }
    }

    public void update(){

        if (match.matchType.equals("CircularTimeMatch"))
            CircularTimeMatchIsFinishedTime();

        if (match.matchType.equals("StraightTimeMatch"))
            StraightTimeMatchIsFinishedTime();

        if (match.matchType.equals("CircularRealMatch"))
            timeFinishedCircularRealRace();

        if (match.matchType.equals("StraightRealMatch"))
            timeFinishedStraightRealRace();

        setCurrentTime();

        if (GameEngine.isCollisionOccurred(this) != null)
            GameEngine.collision(this, GameEngine.isCollisionOccurred(this));

        //checks wall collision
        if (isCollisionOccurred()){
            collision();
        }
        currentLocationPoint = updateLocation(currentLocationPoint);
        frontLeft = updateLocation(frontLeft);
        frontRight = updateLocation(frontRight);
        rearLeft = updateLocation(rearLeft);
        rearRight = updateLocation(rearRight);
        updateStreet();
        //updateAcceleration();
        updateSpeed();
        visitIntersection();
    }

    //Time
    //sets startTime.
    public void start(){
        Date start = new Date();
        startTime = start.getTime();
        roundNumberCounter = 0;
    }
    public void setCurrentTime(){
        Date date = new Date();
        long time = date.getTime();
        currentTime = startTime - time;
    }

    public void visitIntersection(){
        if (!(currentStreet.equals(null))){
            if (currentLocationPoint.getX() < currentStreet.getEnd().getPoint4().getX() &&
                    currentLocationPoint.getX() > currentStreet.getEnd().getPoint3().getX() &&
                    currentLocationPoint.getY() < currentStreet.getEnd().getPoint2().getY() &&
                    currentLocationPoint.getY() > currentStreet.getEnd().getPoint1().getY()) {
                visitedIntersections.add(currentStreet.getEnd());
            }

            if (currentLocationPoint.getX() < currentStreet.getStart().getPoint4().getX() &&
                    currentLocationPoint.getX() > currentStreet.getStart().getPoint3().getX() &&
                    currentLocationPoint.getY() < currentStreet.getStart().getPoint2().getY() &&
                    currentLocationPoint.getY() > currentStreet.getStart().getPoint1().getY()) {
                visitedIntersections.add(currentStreet.getStart());
            }
        }
    }

    @Override
    public void run() {
        update();
    }

    public double getRealMatchRecord() {
        return RealMatchRecord;
    }

    public void setRealMatchRecord(double realMatchRecord) {
        RealMatchRecord = realMatchRecord;
    }
}
