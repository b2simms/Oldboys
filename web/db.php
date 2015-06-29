<?php
function getDB() {
	$dbhost="localhost";
	$dbuser="root";
	$dbpass="";
	$dbname="b5_16292881_test";
	$dbConnection = new PDO("mysql:host=$dbhost;port=3306;dbname=$dbname", $dbuser, $dbpass);	
	//$dbConnection = new PDO('mysql:host=localhost;port=3306;dbname=testing', 'tester', 'captain-h4mm3r');
	$dbConnection->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
	return $dbConnection;
}
?>