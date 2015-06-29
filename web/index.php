<?php

require 'Slim/Slim.php';

include_once 'schedule.php';
include_once 'standings.php';
include_once 'scorers.php';
include_once 'messages.php';
include_once 'team.php';
include_once 'login.php';
include_once 'player.php';

\Slim\Slim::registerAutoloader();

$app = new \Slim\Slim();

$app->get('/schedule/:team', 'getSchedule');
$app->get('/schedule', 'getScheduleAll');
$app->post('/schedule/:id', 'postScheduleUpdate');
$app->get('/standings', 'getStandings');
$app->get('/scorers', 'getScorers');
$app->get('/messages', 'getMessages');
$app->post('/messages', 'postMessage');
$app->get('/team', 'getTeam');
$app->get('/login/:name', 'getLogin');
$app->post('/player/updateMessageViewTime', 'postMessageViewTime');

echo '<a href = "web/schedule.php" > schedule </a>';

$app->run();

function getSchedule($team) {
    
    $schedule = new Schedule();
		
    echo $schedule->getSchedule($team);
}

function getScheduleAll() {
    
    $schedule2 = new Schedule();
		
    echo $schedule2->getScheduleAll();
}

function postScheduleUpdate($id) {
    
    $newScheduleUpdate = new Schedule();
		
    echo $newScheduleUpdate->postScheduleUpdate($id);
}

function getStandings() {
    
    $standings = new Standings();
		
    echo $standings->getStandings();
}

function getScorers() {
    
    $scorers = new Scorers();
		
    echo $scorers->getScorers();
}

function getMessages() {
    
    $messages = new Messages();
		
    echo $messages->getMessages();
}

function postMessage() {
    
    $newMessage = new Messages();
		
    echo $newMessage->postMessage();
}

function getTeam() {
    
    $team = new Team();
		
    echo $team->getTeam();
}

function getLogin($name) {
    
    $login = new Login();
		
    echo $login->getLogin($name);
}

function postMessageViewTime() {
    
    $newMessageViewTime = new Player();
		
    echo $newMessageViewTime->postMessageViewTime();
}


		