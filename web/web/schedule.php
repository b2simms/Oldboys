<?phpinclude_once '../schedule.php'; $schedule = new Schedule();  $scheduleAll = json_decode( $schedule->getScheduleAll() );  $games = $scheduleAll->games; ?><!DOCTYPE html><html><body><table border=1>      <?php foreach($games as $row): ?>		   <tr>			  <td>				<?= $row->game_id ?>			   </td>			   <td>				<?= $row->game_id ?>			   </td>			   <td>				<?= $row->game_id ?>			   </td>			   <td>				<?= $row->game_id ?>			   </td>			   <td>				<?= $row->game_id ?>			   </td>			   <td>				<?= $row->game_id ?>			   </td>			</tr>   <?php endforeach; ?></table></body><html>

<?php echo ob_get_clean(); ?>


	