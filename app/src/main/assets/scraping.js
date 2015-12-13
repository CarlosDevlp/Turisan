var search=undefined;

$(document).on("ready",function(){		

		$("h1").html("Let's make Scraping!!!!");

		search= function (city){ //función para realizar búsquedas

			//web para hacer scraping
			var url="https://www.bing.com/images/search?q="+city,css="div#dg_yw div.imgres a";

			//comenzar el scraping
			Scraping.scrape(url,css,function(data){
				Scraping.extract(data);				
				str=Scraping.extract(data,"m");
				try{
					eval("var temp= "+str+";");
					img=temp.imgurl;						
					$(".result").html("<img src='"+img+"' />");
					delete temp;
				}catch(err){

				}
				
			});


		}
		
				



});



/*Scraping*/	
	Scraping={
				data:undefined, //data obtenida				
				dump: function(obj,str){//función para mostrar toda la estructura a través de DV

					str=str || '';
					console.log(str+"{");
					for(var i=0 in obj)
						if(typeof obj[i] == 'object')
							this.dump(obj[i],str+' ');
						else
							console.log("\n"+str+''+obj[i]);
					console.log(str+"}");

				},
				extract: function (obj,attr){//extractora de datos
					var res=null;
					for(var i=0 in obj){

						if(i==attr)
							return obj[i];

						if(typeof obj[i] == 'object'){
							res=this.extract(obj[i],attr);
							if(res)
								return res;
						}

					}
					
				},
				scrape: function (){//scraping de webs
				
						var cb= function(data){ console.log(data)};
						var uri='SELECT * FROM data.html.cssselect WHERE url="http://elcomercio.pe/" AND css="section#ec-ultimas"';
							
						switch(arguments.length){				
							case 1:// 0:cb
								cb= arguments[0];
							break;
							case 2:// 0:url
								uri='SELECT * FROM data.html.cssselect WHERE url="'+arguments[0]+'" ';
								cb= arguments[1];
							break;
							case 3://0:url , 1:css 								
								uri='SELECT * FROM data.html.cssselect WHERE url="'+arguments[0]+'" AND css="'+arguments[1]+'" ';
								cb= arguments[2];
							break;
						}

						uri=encodeURIComponent(uri);//codificar el uri
						//ejecutar AJAX
						$.getJSON(			 
							  'https://query.yahooapis.com/v1/public/yql?q='+uri+'&diagnostics=true&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys&callback=',
							  {				  	
							    format: 'json'
							  },
							  function(data) {
									cb(data);
							  }
						);

				}
	};