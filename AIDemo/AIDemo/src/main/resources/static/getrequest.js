$( document ).ready(function() {

    $("#tagcloud a").tagcloud({
        size: {start: 12, end: 36, unit: "px"},
        color: {start: '#3498DB', end: '#46CFB0'}
    });


    var url = window.location.href.substring(0, location.href.lastIndexOf("/")+1);

	// GET REQUEST
	$("#submit").click(function(event){
		event.preventDefault();
		ajaxGet();
	});



	
	// DO GET
	function ajaxGet(){
        $("#divImages").html('');
        $("#tagcloud").hide();
        var tag=$("#search").val();
        var finalUrl = url + "AIService/getObjectDetails/"+tag;
        $.ajax({
            type : "GET",
            dataType: 'json',
            url : finalUrl,
            success: function(result){
                $("#search").val('');
                if(result.length==0){$("#divImages").append("<h1>No Images Found  <b>"+tag+"</b> keyword</h1>");$("#tagcloud").show(); return;}
                $("#divImages").append("<h1>Search Result for <span class='spnKeywords'>"+tag+"</span></h1>");
                    $.each(result, function(i, imgObjects){
                        var imgString="<div class='gallery'>";
                        imgString += "<a>";
                        imgString += "<img src='http://localhost/upload/imageoutput/"+imgObjects.imageId+"_orginal.jpg' width='600' height='500'/>";
                        imgString += "</a>";
                        imgString += "<div class='desc'><b>Available Keywords: </b>"+imgObjects.objecttag +" <a data-imageid='"+imgObjects.imageId+"'  id='objView"+i+"'>Image Detail View</a></div>";
                        imgString += "</div>";
                        $("#divImages").append(imgString);

                        $('#objView'+i).click(function(){
                            mfnObjectView($(this).data('imageid'));
                        });

                        //$('#getResultDiv .list-group').append('<li><h4 class="list-group-item">'+imgObjects.objecttag +'</h4></li>')
                        //var objectDetails = "ImageId=" + imgObjects.imageId + " <br\>";
                        //$("#divImages").append("<img src='http://localhost/upload/imageoutput/"+imgObjects.imageId+"_orginal.jpg'/>");
                        //$('#getResultDiv .list-group').append('<li><h4 class="list-group-item">'+imgObjects.objecttag +'</h4></li>')
                    });

                }
        });

    }


    function mfnObjectView(ImageId){

        $("#dialog").html("");
        $("#dialog").append("<img src='http://localhost/upload/imageoutput/"+ImageId+".jpg'/>");
        setTimeout(function(){ $("#dialog" ).dialog({width: 'auto',resizable: false,}); }, 1000);
    }

})