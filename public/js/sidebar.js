	onload=function(){
			var timer=null;
			var mainsidebar =document.querySelector(".mainsidebar");
				document.querySelector(".sidebarcontroler").onclick=function(){
					clearInterval(timer);
					if(document.querySelector(".fa-navicon")){
				mainsidebar.style.display='block';
				timer=setInterval(function(){
					if(mainsidebar.offsetWidth>349){
					clearInterval(timer);
					document.querySelector(".fa-navicon").className="fa fa-arrow-right";
					timer=null;
				}
					mainsidebar.style.width=mainsidebar.offsetWidth+50+'px';
					document.getElementById('outside').style.paddingRight=mainsidebar.offsetWidth+'px';
				},30)			
			}else if(document.querySelector(".fa-arrow-right")){
					timer=setInterval(function(){
					if(mainsidebar.offsetWidth<=0){
					document.querySelector(".fa-arrow-right").className="fa fa-navicon";
					mainsidebar.style.display='none';
					clearInterval(timer);
					timer=null;
				}
					mainsidebar.style.width=mainsidebar.offsetWidth-50+'px';
					document.getElementById('outside').style.paddingRight=mainsidebar.offsetWidth+'px';
				},30)			
				}}
				}	
//滑入划出动画