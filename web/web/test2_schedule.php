<!DOCTYPE html>
<!--[if lt IE 7]><html class="no-js lt-ie9 lt-ie8 lt-ie7" lang="en" xml:lang="en"><![endif]-->
<!--[if IE 7]><html class="no-js lt-ie9 lt-ie8" lang="en" xml:lang="en"><![endif]-->
<!--[if IE 8]><html class="no-js lt-ie9" lang="en" xml:lang="en"><![endif]--><!--[if gt IE 8]><!-->

<html class="no-js" lang="en" xml:lang="en" xmlns="http://www.w3.org/1999/xhtml">
<!--<![endif]-->

<head>
  
  <meta content="http://www.oldboys.ca/index.htm" name="mobileRedirectUrl" />

  <title>Old Boys Soccer League</title>
  <meta property="og:image:type" content="png" />
  <meta property="og:image:width" content="1200" />
  <meta property="og:image:height" content="630" />
  <meta property="og:image" content="../oldboys_pictures/soccerball.png" />
  
  <link type='text/css' title='standard' rel='stylesheet' href=
  'http://css.fifa.com/components/style/framework/lang=en/base.css?v=aaab3fa7b433523054caeba3b6fd8a6c' />
 
  <link type='text/css' title='standard' rel='stylesheet' href=
  'http://css.fifa.com/components/style/framework/lang=en/womensworldcup/base.css?v=c8d5cbcfd5b15f0643c1cddd54c13b7e' />
  
</script>
</head>


<body class="en" data-enablematchlive="true">
  <div id="wrap">
    

    <div class="navbar navbar-sectionheader" >
      <div class="container">
        <div class="header-wrap contentheader">
          <div class="title-wrap">
            <h1 class="title"><a href="http://www.oldboys.ca/index.htm">Old Boys Soccer League<span class="trn-date">Fredericton Summer League</span></a></h1>
          </div>
        </div>

        <div class="nav-wrap">
          <ul class="nav nav-pills lev2 items7">
            <li id="mitem-matches" class="menu-2-matches first">
              <a title="Matches" href="schedule.php"><span>Matches</span></a>
            </li>

            <li id="mitem-teams" class="menu-2-teams">
              <a title="Standings" href="standings.php"><span>Standings</span></a>
            </li>

            <li id="mitem-femaleScorers" class="menu-2-Scorers">
              <a title="Scorers" href="scorers.php"><span>Scorers</span></a>
            </li>

            <li id="mitem-standingsgroups" class="menu-2-standings">
              <a title="Messaging" href="messaging.php"><span>Messaging</span></a>
            </li>
          </ul>
        </div>
      </div>
    </div>

    <div id="content-wrap">
      <div class="container">
        <div class="page-share hidden-print">
          <div class="header-share">
            <div class="header-listchannel">
              <span class="header-share-title">Follow us on</span>

              <ul class="social-list">
                <li class="social-item">
                  <a href="https://www.facebook.com/frederictonoldboys" target="_blank" class="ico-24-facebook-g"></a>
                </li>
              </ul>
            </div>

          </div>
        </div>

        <div class="navbar navbar-pageheader navbar-matchlistheader nav-scrollspy">
          <div class="container">
            <div class="module">
              <div class="inner" data-require="scrollspy">
                <h1 class="title"><span>Matches</span></h1><style>

                </style>

		  
		<?php

			include_once '../schedule.php';

			$schedule = new Schedule();

			 $scheduleAll = json_decode( $schedule->getScheduleAll() );
			 $games = $scheduleAll->games;
			 
		?>

			
			   
		
	<?php foreach($games as $row): ?>	
		
          <div class="match-list">
            <div class="matches">
              <div class="match-list-round anchor" id="268020" data-roundid="268020">
                <h2>Season 2015</h2>
              </div>
			  
			  <br><br><br>
			  
			  
				   
			  			  
	  <div class="match-list-date anchor" id="20150606">
		
		
		
							
		
		<div class="time-converter">
		  <span class="my-time">Game id: <?= $row->game_id ?></span>
		</div>
				
		
				
                <div class="col-xs-12 clear-grid">
                  <div data-id="300269484" class="mu result">
                    <a href="/womensworldcup/matches/round=268020/match=300269484/index.html#nosticky" class="mu-m-link">
                    <div class="mu-i">
                      <div class="mu-i-datetime">
                        06 Jun 2015 - 16:00 <span class="wrap-localtime">Local time</span>
                      </div>

                      <div class="mu-i-date">
                        06 Jun 2015
                      </div>

                      <div class="mu-i-matchnum">
                        Match 1
                      </div>

                      <div class="mu-i-cupname">
                        FIFA Women&#39;s World Cup Final
                      </div>

                      <div class="mu-i-group">
                        Group A
                      </div>

                      <div class="mu-i-location">
                        <div class="mu-i-stadium">
                          Commonwealth Stadium
                        </div>

                        <div class="mu-i-venue">
                          Edmonton
                        </div>
                      </div>
                    </div>

                    <div class="mu-day">
                      <span class="t-day">06</span><span class="t-month">Jun</span>
                    </div>

                    <div class="mu-m">
                      <div class="t home" data-team-id="1883718">
                        <div class="t-i i-4">
                          <span class="t-i-wrap"><img src="../oldboys_pictures/soccerball.png" " alt="Canada" title="Canada"
                          class="CAN i-4-flag flag" /></span>
                        </div>

                        <div class="t-n">
                          <span class="t-nText">Canada</span><span class="t-nTri">CAN</span>
                        </div>
                      </div>

                      <div class="t away" data-team-id="1882892">
                        <div class="t-i i-4">
                          <span class="t-i-wrap"><img src="http://img.fifa.com/images/flags/4/chn.png" alt="China PR" title=
                          "China PR" class="CHN i-4-flag flag" /></span>
                        </div>

                        <div class="t-n">
                          <span class="t-nText">China PR</span><span class="t-nTri">CHN</span>
                        </div>
                      </div>

                      <div class="s">
                        <div class="s-fixture">
                          <div class="s-status">
                            Full-time
                          </div>

                          <div class="s-status-abbr">
                            FT
                          </div>

                          <div class="s-score s-date-HHmm" data-daymonthutc="0606">
                            <span class="s-scoreText">1-0</span>
                          </div>
                        </div>
                      </div>

                      <div class="mu-reasonwin"></div>

                      <div class="mu-reasonwin-abbr"></div>
                    </div></a>
                  </div>
                </div>
               
                </div>
              </div>
			  
			  
			<?php endforeach; ?>
		<?php echo ob_get_clean(); ?>
   

              
</body>
</html>
