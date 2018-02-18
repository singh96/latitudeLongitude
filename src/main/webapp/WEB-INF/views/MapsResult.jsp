<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<head>
    <title>Location</title>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <style>
        #map-canvas {
          height: 600px;
          height: 600px;
          margin: 0px;
          padding: 0px
        }
    </style>

	<script type="text/javascript" src="//maps.googleapis.com/maps/api/js?key=AIzaSyATPLxuLnHUjEXLAyQ9AFMUA0datWx363s"></script>

    <script type="text/javascript">
    	var map = null;
    	
        function showlocation(lat, lon) {
            initMap();
           	var latLong = new google.maps.LatLng(lat, lon);
      	    var marker = new google.maps.Marker({
				    position: latLong
				});      

      	    marker.setMap(map);
      	    map.setZoom(8);
      	    map.setCenter(marker.getPosition());
        }
      
      //google.maps.event.addDomListener(window, 'load', initMap);
        function initMap() {
            var mapOptions = {
                center: new google.maps.LatLng(0, 0),
                zoom: 1,
                mapTypeId: google.maps.MapTypeId.ROADMAP
            };
            map = new google.maps.Map(document.getElementById("map-canvas"), mapOptions);
        }
    </script>
</head>

<body>

	<table border="1">
	<tr>
		<th>Latitude</th>
		<th>Longitude</th>
		<th>Address</th>
        <th>On Map</th>
	</tr>
	<c:forEach items = "${geo}" var = "geo">
        <tr>
            <td>
                <c:out value="${geo.latitude}"/>
            </td>
            <td>
                <c:out value="${geo.longitude}"/>
            </td>
            <td>
                <c:out value="${geo.address}"/>
            </td>
            <td>
            <input type="button" value="Show on Map"
		    	onclick="javascript:showlocation(${geo.latitude} , ${geo.longitude})" />   <br/>
            <td>
        </tr>
    </c:forEach>
    </table>
<div id="map-canvas"/>
</body>
</html>