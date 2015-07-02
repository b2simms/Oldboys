<!DOCTYPE html><!--[if lt IE 7]><html class="no-js lt-ie9 lt-ie8 lt-ie7" lang="en" xml:lang="en"><![endif]--><!--[if IE 7]><html class="no-js lt-ie9 lt-ie8" lang="en" xml:lang="en"><![endif]--><!--[if IE 8]><html class="no-js lt-ie9" lang="en" xml:lang="en"><![endif]--><!--[if gt IE 8]><!--><html class="no-js" lang="en" xml:lang="en" xmlns="http://www.w3.org/1999/xhtml"><!--<![endif]--><head>    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>    <title>Old Boys Soccer League</title>  <link rel="stylesheet" href="css/uikit.min.css" />  <script src="jquery-2.1.4.min.js"></script>  <script src="js/uikit.min.js"> </script>    <link type='text/css' title='standard' rel='stylesheet' href='style_schedule.css' />  <link type='text/css' title='standard' rel='stylesheet' href='media.css' /></head><body class="en" >  <div class="container">        <div class="navbar navbar-sectionheader">                <div class="header-top">           <img class="header-image" src="../oldboys_pictures/OldboysLogoPNG.png" />        </div>                <div class="menu-wrap">           <!-- This is the container enabling the JavaScript -->          <div class="uk-button-dropdown" data-uk-dropdown>            <!-- This is the button toggling the dropdown -->            <button class="uk-button"> </button>            <!-- This is the dropdown -->            <div class="uk-dropdown uk-dropdown-small">                <ul class="uk-nav uk-nav-dropdown">                    <li><a href="/oldboys/web/schedule.php">Matches</a></li>                    <li><a href="/oldboys/web/standings.php">Standings</a></li>                    <li><a href="/oldboys/web/scorers.php">Scorers</a></li>                    <li><a href="/oldboys/web/messaging.php">Messaging</a></li>                </ul>            </div>          </div>          <ul id="menu">            <li>              <a title="Matches" href="/oldboys/web/schedule.php"><span>Matches</span></a>            </li>            <li>              <a title="Standings" href="/oldboys/web/standings.php"><span>Standings</span></a>            </li>            <li>              <a title="Scorers" href="/oldboys/web/scorers.php"><span>Scorers</span></a>            </li>            <li>              <a title="Messaging" href="/oldboys/web/messaging.php"><span>Messaging</span></a>            </li>          </ul>        </div>          </div>                    <?php            include_once '../schedule.php';            $schedule = new Schedule();             $scheduleAll = json_decode( $schedule->getScheduleAll() );             $games = $scheduleAll->games;                     ?>                                                      <?php foreach($games as $row): ?>                                                                         <div class="uk-grid">                        <div class="uk-width-1-5">                                                      <div class="team1_image">                              <span class="team1-png"><img src=                                <?php                                   switch($row->team1) {                                    case "Fredericton Kia":                                        echo "../oldboys_pictures/frederictonkia.png";                                        break;                                    case "Gunners":                                        echo "../oldboys_pictures/gunners.png";                                        break;                                    case "Sporting":                                        echo "../oldboys_pictures/sporting.png";                                        break;                                    case "Growlers United":                                        echo "../oldboys_pictures/growlers.png";                                        break;                                    case "Picaroons":                                        echo "../oldboys_pictures/picaroons.png";                                        break;                                    case "Rogue Galleons":                                        echo "../oldboys_pictures/galleons.png";                                        break;                                    default:                                        echo "../oldboys_pictures/OldboysLogoPNG.png";                                        break;                                  }                                                                  ?> /></span>                            </div>                                                                            </div>                          <div class="uk-width-3-5">                            <div class="uk-grid">                              <div class="uk-width-1-3">                                                                  <span class="locationText">                                    <?= $row->time ?>                                    <br/>                                    <?= $row->location ?>                                  </span>                                                              </div>                              <div class="uk-width-1-3">                                                                    <span class="scoreText">                                    <?= $row->team1_score ?> - <?= $row->team2_score ?>                                  </span>                                                             </div>                               <div class="uk-width-1-3">                                                                   <span class="dateText">                                      <?= $row->day ?>, <?= $row->date?>                                  </span>                                                              </div>                              </div>                                                    </div>                          <div class="uk-width-1-5">                                                      <div class="team2_image">                              <span class="team2-png"><img src=                                <?php                                   switch($row->team2) {                                    case "Fredericton Kia":                                        echo "../oldboys_pictures/frederictonkia.png";                                        break;                                    case "Gunners":                                        echo "../oldboys_pictures/gunners.png";                                        break;                                    case "Sporting":                                        echo "../oldboys_pictures/sporting.png";                                        break;                                    case "Growlers United":                                        echo "../oldboys_pictures/growlers.png";                                        break;                                    case "Picaroons":                                        echo "../oldboys_pictures/picaroons.png";                                        break;                                    case "Rogue Galleons":                                        echo "../oldboys_pictures/galleons.png";                                        break;                                    default:                                        echo "../oldboys_pictures/OldboysLogoPNG.png";                                        break;                                  }                                                                  ?>                                /></span>                            </div>                                                                              </div>                      </div>                                         <br />                             <?php endforeach; ?><?php echo ob_get_clean(); ?>      </div>  </body></html>