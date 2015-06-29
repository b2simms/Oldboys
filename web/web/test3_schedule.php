<!DOCTYPE html>
<!--[if lt IE 7]><html class="no-js lt-ie9 lt-ie8 lt-ie7" lang="en" xml:lang="en"><![endif]-->
<!--[if IE 7]><html class="no-js lt-ie9 lt-ie8" lang="en" xml:lang="en"><![endif]-->
<!--[if IE 8]><html class="no-js lt-ie9" lang="en" xml:lang="en"><![endif]--><!--[if gt IE 8]><!-->

<html class="no-js" lang="en" xml:lang="en" xmlns="http://www.w3.org/1999/xhtml">
<!--<![endif]-->

<head>
  
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  
  <title>Old Boys Soccer League</title>

  <link rel="stylesheet" href="css/uikit.min.css" />
  <script src="jquery-2.1.4.min.js"></script>
  
  <link type='text/css' title='standard' rel='stylesheet' href='site.css' />
</head>

<body class="en" >
  <div>
    <div class="navbar navbar-sectionheader">
        <div class="header-wrap contentheader">
          <span class="oldboyslogo_image"><img src="../oldboys_pictures/OldboysLogoPNG.png" /></span>
        </div>

        <div class="menu-wrap">
          <ul id="menu">
            <li>
              <a title="Matches" href="schedule.php"><span>Matches</span></a>
            </li>

            <li>
              <a title="Standings" href="standings.php"><span>Standings</span></a>
            </li>

            <li>
              <a title="Scorers" href="scorers.php"><span>Scorers</span></a>
            </li>

            <li>
              <a title="Messaging" href="messaging.php"><span>Messaging</span></a>
            </li>
          </ul>
        </div>
      
    </div>


<ul class="uk-thumbnav uk-grid-width-1-6">
    <li><a href=""><img src="../oldboys_pictures/frederictonkia.png">
      </a></li>
    <li><a href=""><img src="../oldboys_pictures/gunners.png">
      </a></li>
    <li><a href=""><img src="../oldboys_pictures/sporting.png">
      </a></li>
    <li><a href=""><img src="../oldboys_pictures/growlers.png">
      </a></li>
    <li><a href=""><img src="../oldboys_pictures/picaroons.png">
      </a></li>
    <li><a href=""><img src="../oldboys_pictures/galleons.png">
      </a></li>
</ul>


    
				
				<?php

						include_once '../schedule.php';

						$schedule = new Schedule();

						 $scheduleAll = json_decode( $schedule->getSchedule('Fredericton Kia') );

						 $games = $scheduleAll->games;
						 
				?>              
                    

                    <?php foreach($games as $row): ?>   
                            

                    <div class="uk-container">
                      <div class="uk-grid">

                        <div class="uk-width-1-5">
                          <div class="uk-panel-box-no-padding">

                            <div class="team1_image">
                              <span class="team1-png"><img src=
                                <?php 
                                  switch($row->team1) {
                                    case "Fredericton Kia":
                                        echo "../oldboys_pictures/frederictonkia.png";
                                        break;
                                    case "Gunners":
                                        echo "../oldboys_pictures/gunners.png";
                                        break;
                                    case "Sporting":
                                        echo "../oldboys_pictures/sporting.png";
                                        break;
                                    case "Growlers United":
                                        echo "../oldboys_pictures/growlers.png";
                                        break;
                                    case "Picaroons":
                                        echo "../oldboys_pictures/picaroons.png";
                                        break;
                                    case "Rogue Galleons":
                                        echo "../oldboys_pictures/galleons.png";
                                        break;
                                    default:
                                        echo "../oldboys_pictures/OldboysLogoPNG.png";
                                        break;
                                  }
                                  
                                ?> /></span>
                            </div>

                          
                          </div>
                        </div>  

                        <div class="uk-width-3-5">
                            <div class="uk-grid">
                              <div class="uk-width-1-3">
                                <div class="uk-panel-box-no-padding">
                                  <span class="locationText">
                                    <?= $row->time ?>
                                    <br/>
                                    <?= $row->location ?>
                                  </span>
                                </div>
                              </div>
                              <div class="uk-width-1-3">  
                                <div class="uk-panel-box-no-padding">
                                  <span class="scoreText">
                                    <?= $row->team1_score ?> - <?= $row->team2_score ?>
                                  </span>
                                </div>
                              </div> 
                              <div class="uk-width-1-3"> 
                                <div class="uk-panel-box-no-padding">
                                  <span class="dateText">
                                      <?= $row->day ?>, <?= $row->date?>
                                  </span>
                                </div>
                              </div>  
                            </div>  
                          
                        </div>  

                        <div class="uk-width-1-5">
                          <div class="uk-panel-box-no-padding">
                            <div class="team2_image">
                              <span class="team2-png"><img src=
                                <?php 
                                  switch($row->team2) {
                                    case "Fredericton Kia":
                                        echo "../oldboys_pictures/frederictonkia.png";
                                        break;
                                    case "Gunners":
                                        echo "../oldboys_pictures/gunners.png";
                                        break;
                                    case "Sporting":
                                        echo "../oldboys_pictures/sporting.png";
                                        break;
                                    case "Growlers United":
                                        echo "../oldboys_pictures/growlers.png";
                                        break;
                                    case "Picaroons":
                                        echo "../oldboys_pictures/picaroons.png";
                                        break;
                                    case "Rogue Galleons":
                                        echo "../oldboys_pictures/galleons.png";
                                        break;
                                    default:
                                        echo "../oldboys_pictures/OldboysLogoPNG.png";
                                        break;
                                  }
                                  
                                ?>

                                /></span>
                            </div>

                            
                          </div>  
                        </div>

                      </div>
                    </div>   

                    <br />             

                <?php endforeach; ?><?php echo ob_get_clean(); ?>
    
</body>
</html>
