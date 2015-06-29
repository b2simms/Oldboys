<?phpinclude 'db.php';
class Scorers {
function getScorers(){
	
       $sql = "SELECT * FROM  Scorers ORDER BY goals desc, last_name";

                     	
       try {
		$db = getDB();
		$stmt = $db->query($sql);  
		$users = $stmt->fetchAll(PDO::FETCH_OBJ);
		return '{"games": ' . json_encode($users). '}';
	} catch(PDOException $e) {
			
		echo '{"error":{"text1":'. $e->getMessage() .'}}'; 
	}
}
}