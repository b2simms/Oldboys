<?phpinclude 'db.php';
class Standings {
function getStandings(){

       $sql = "SELECT * FROM  Standings ORDER BY points desc";

                     	
       try {
		$db = getDB();
		$stmt = $db->query($sql);  
		$users = $stmt->fetchAll(PDO::FETCH_OBJ);
		return '{"games": ' . json_encode($users). '}';
	} catch(PDOException $e) {
			
		echo '{"error":{"text1":'. $e->getMessage() .'}}'; 

}}}