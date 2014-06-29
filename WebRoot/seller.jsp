
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Online Store</title>
    <meta charset="utf-8" />
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="css/seller_css/seller.css" />
    <link rel="stylesheet" type="text/css" href="css/common.css" />
    <!-- <script src="js/geo.js" type="text/javascript"></script> -->
    <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
    <script src="ckeditor/ckeditor.js"></script>
    
    <script type="text/javascript">
    	$(document).ready(function(){
    	
    	
    		$("#passwordConfirmBtn").click(function() {
    			
    			var oldPassword = $("#oldPassword").val();
    			var newPassword = $("#newPassword").val();
    			var confirmPassword = $("#confirmPassword").val();
    			
    			if(oldPassword == ""  || newPassword == "" || confirmPassword == "") {
    				alert("the password can't be null");
    			} else if(newPassword != confirmPassword) {
    				alert("the password is not equal");
    			} else {
    			
    				$.get("changePassword", {"oldPassword": oldPassword, "newPassword": newPassword, "confirmPassword": confirmPassword}, function(data) {
    					
    					
    					if(data == "success") {
    						alert("modify success");
    					} else if(data == "notequal") {
    						alert("the password is wrong");
    					}
    				});
    				// $("#security_form").submit();
    			}
    			
    			
    		});
    	
    		// when click the basicinfo button
    		$("#basicInfo").click(function(){
    			
    			console.log("click basicInfo");
    			
    		});
    		
    		$("#apply_btn").click(function() {
    			
    			
    			console.log("OK");
    			var msg = $("#applyTextArea").val();
    			
    			console.log("msg: " + msg);
    			
    			if(msg == "") {
    				alert("attribute cant not be null!");
    				return;
    			}
    			
    			$.get("applyShop", {"msg": msg}, function(data) {
    				if(data == "success") {
    					alert("success");
    					$("#applyMsg").val("");
    				}
    			});
    		});
    		
    		
    		// show the product list
    		$("#productList").click(function(){
    			
    			$.get("productList", function(data){
    			
    				var temp = eval("(" + data + ")");
    				
    				console.log(temp);
    		
    				var str = "<tr id='listTableHeader'>" + 
    				"<th>Product</th>" + 
    				"<th>PublishTime</th>" + 
    				"<th>Price</th>" + 
    				/* "<th>InStock</th>" +  */
    				"<th>Operation</th>" + 
    				"</tr>";
    				
    				for(var i = 0; i < temp.length; i++) {
    				
    					var year = temp[i].timeCreated.year + 1900;
    					var month = temp[i].timeCreated.month + 1;
    					var date = temp[i].timeCreated.date;
    					var time = year + "-" + month + "-" + date;
    				// /item/67
    					str = str + "<tr class='listRow'>" + 
    								  "<td>" + 
    								    "<div class='left listItemImgDiv'>" + 
    								      "<img src=" + temp[i].urlPicture + ">" + 
    								    "</div>" + 
    								    "<div class='left listItemDescDiv'>" + 
    								      "<div class='listItemDesc'>" + 
    								        "<a target=\"_blank\"href='/C1_ParknShop/item/" + temp[i].id + "'>"  + temp[i].name + "</a>" + 
    								      "</div>" + 
    								      "<div class='listItemExtra'></div>" + 
    								    "</div>" + 
    								  "</td>" + 
    								  "<td>" + 
    								    "<span> " + time + " </span>" + 
    								  "</td>" + 
    								  "<td>" + 
    								    "<span>" + temp[i].price + "</span>" + 
    								  "</td>" + 
    								 /*  "<td>" +
                						"<span>8</span>" + 
           							   "</td>" +  */
    								  "<td>" + 
    								    /* "<span class='operationItem'><a href='#' class='mofify_btn' id='modify" + temp[i].id + "'>Modify</a></span>" +  */
    								    "<span class='operationItem'><a href='#' class='delete_item_btn' id='delete" + temp[i].id + "'>Delete</a></span>" + 
    								  "</td>" +
    								"</tr>";
    				}
    				
    				$("#listTable").html(str);
    			});
    	
    		});
    		
    		/* 
    		
    		$(document).on('click', ".mofify_btn", function(e) {
    			
    			var itemId = $(e.target).attr("id").substring(6);
				$.get("modifyItem", {"id": itemId}, function(data) {
					
					console.log(data);
				});    			
    		});	 */
    		
    		$(document).on('click', ".delete_item_btn", function(e){
    			
    			var itemId = $(e.target).attr("id").substring(6);
    			$.get("deleteItem", {"id": itemId}, function(data) {
    				if(data == "success") {
    					alert("success");
    					$("#productList").click();
    				}
    			});
    		});
    		
    		$("#recordList").click(function() {
    		
    			$.get("record", function(data){
    				
    				var temp = eval("(" + data + ")");
    				
    				console.log(temp);
    		
    				var str = "<tr id='recordTableHeader'>" + 
    							"<th>Product</th>" + 
    							"<th>Sold At</th>" + 
    							"<th>Price</th>" + 
    							"<th>Quantity</th>" +
    							"<th>Buyer</th>" + 
    							"<th>State</th>" + 
    							"<th>Operation</th>" + 
    						   "</tr>";
    				/*
    public final static Short UNPAID = 0;
	public final static Short PAID = 1;
	public final static Short DELIVERING = 2;
	public final static Short FINISHED = 3;
	public final static Short EXCEPTION = 4;
	public final static Short CANCELLED = 5;
    				*/
    				for(var i = 0; i < temp.length; i++) {
    					
    					var year = temp[i].soldTime.year + 1900;
    					var month = temp[i].soldTime.month + 1;
    					var date = temp[i].soldTime.date;
    					
    					var time = year + "-" + month + "-" + date;
    					
    					var stateStr = "";
    					var isDisabled = "";
    					if(temp[i].state == "0") {
    						stateStr = "unpaid";
    						isDisabled = "disabled='disabled'";
    					} else if(temp[i].state == "1") {
    						stateStr = "paid";
    					} else if(temp[i].state == "2") {
    						stateStr = "delivering";
    						isDisabled = "disabled='disabled'";
    					}else if(temp[i].state == "3") {
    						stateStr = "finished";
    						isDisabled = "disabled='disabled'";
    					}else if(temp[i].state == "4") {
    						stateStr = "exception";
    						isDisabled = "disabled='disabled'";
    					}else if(temp[i].state == "5") {
    						stateStr = "finished";
    						isDisabled = "disabled='disabled'";
    					}
    					
    					str = str + "<tr class='recordRow'>" + 
    					
    								  "<td>" + 
    								    "<div class='left recordItemImgDiv'>" + 
    								      "<img src='" + temp[i].itemPic + "'>" + 
    								    "</div>" + 
    								    "<div class='left recordItemDescDiv'>" + 
    								        "<div class='recordItemDesc'>" + temp[i].itemName +  "</div>" +
                  							"<div class='recordItemExtra'></div>" + 
    								      "</div>" + 
    								  "</td>" + 
    								  
    								  "<td>" + 
    								    "<span> " + time + "</span>" + 
    								  "</td>" + 
    								  "<td>" + 
    								    "<span>$" + temp[i].price + "</span>" + 
    								  "</td>" + 
    								  "<td>" +
                						"<span>" + temp[i].quantity + "</span>" + 
           							   "</td>" + 
    								  "<td>" + 
    								    "<div class='buyer_contact'>" + 
    								    	"<span>" + temp[i].buyerName + "</span>" + 
    								    	"<span>" + temp[i].phone + "</span>" + 
    								    	"<span>" + temp[i].address + "</span>" + 
    								    "</div>" + 
    								  "</td>" +
    								  "<td>" + 
    								  	"<span>" + stateStr + "</span>" + 
    								  "</td>" + 
    								  "<td>" + 
    								    "<input type='button' class='common_btn deliver_btn' value='Delivering' id='deliveringBtn" + temp[i].id + "' " + isDisabled + "/>" + 
    								"</tr>";
    				}
    				
    				console.log(str);
    				
    				$("#recordTable").html(str);
    			});

    		});
    		
    		
    		$(document).on('click', ".deliver_btn", function(e) {
    			
    			console.log("click now");
    			
    			var id = $(e.target).attr("id").substring(13);
    			console.log(id);
    					
    			$.get("delivering", {"id": id}, function(data) {
    				if(data == "success") {
    					alert("successfully modified");
    					$("#recordList").click();
    				}
    			});
    		});
    		
    		$("#publishProduct").click(function(){
    		
    			$.post("getcategory", function(data) {
    			
    				console.log(data);
    				var temp = eval("(" + data + ")");
    				
    				var str = "";
    			
    				for(var i = 0; i < temp.length; i++) {
    					//console.log("id: " + temp[i].id + ";name: " + temp[i].name);
    					var arr = temp[i].name.split("&");
    					str += "<span class='seller_categoryListItem' id='category" + temp[i].id + "'>" + arr[0] + "</span>";
    				}
    				console.log(str);
    				$("#seller_categoryList").html(str);
    				
    				$(".seller_categoryListItem").mouseenter(function() {
    					$(this).css("background-color", "#189918");
    					$(this).css("color", "#ffffff");
						}).mouseleave(function() {
    				$(this).css("background-color", "#efefef");
   					 $(this).css("color", "#333333");
						}).click(function() {
						
   						 $("#sellerCategoryTag").show();
   						
   						 $("#chooseCategoryBtn").val($(this).html());
   						 $("#hiddenCategoryId").val($(this).attr("id").substring(8));
						});;
    			});
    		});
    		
    		
    		$(document).on('click', ".seller_categoryListItem", function(e){
    			
    			var id = $(e.target).attr("id");
    			var categoryId = id.substring(8);
    			
    			$.get("getTag", {"id": categoryId}, function(data) {
    				
    				var temp = eval("(" + data + ")");
    				
    				console.log(temp);
    				
    				/*<span class="sellerCategoryTagItem" data-state="0">Tag1</span>  */
    				
    				var str = "";
    				for(var i = 0; i < temp.length; i++) {
    					str += "<span class='sellerCategoryTagItem' data-state='0' id='" + temp[i].id + "'> " + temp[i].name + "</span>";
    				}
    				
    				console.log(str);
    				
    				$("#sellerCategoryTagList").html(str);
    				
    				 $(".sellerCategoryTagItem").click(function() {
    						if ($(this).attr("data-state") == "0") {
       						 $(this).css("background-color", "#189918");
       						 $(this).css("color", "#ffffff");
       						 $(this).attr("data-state","1");
    					} else {
      						  $(this).css("background-color", "#efefef");
        						$(this).css("color", "#333333");
       						 $(this).attr("data-state","0");
  							  }
	
						});
						
						
    			});
    		});
    		
    		
    		$("#publish_btn").click(function() {
    		
    		
    			var items = $(".uploadImg");
    		
    			var pics = new Array();
    			
    			for(var i = 0; i < items.length; i++) {
    				pics.push($(items[i]).attr("data"));
    			}
    			
    			
    			var name = $("#name").val();
    			//console.log(name);
    		
    			var categoryId = $("#hiddenCategoryId").val();
    			var shuzu = $(".sellerCategoryTagItem");
    			var myArray=new Array();
    			//var k = 0;
    			for(var i = 0; i < shuzu.length;i++)
    			{
    			   if($(shuzu[i]).attr("data-state") == "1")
    			   {
    			      myArray.push($(shuzu[i]).attr("id"));
    			   }
    			}

    			var price = $("#price").val();
    			var promotion = $("#promotion").val();
    			var publishDescription = $("#publish_goodsDesc").val();
    			var extra1 = CKEDITOR.instances.bigshow.getData();
    			
    			if(name == "" || price == "" || publishDescription == "" || extra1 == "") {
    				alert("the attributes can't be null");
    				return;
    			}
    			
    			for(var i = 0 ; i < pics.length; i++) {
    				console.log(pics[i]);
    			}
    			
    			$.post("publishPro", {"name" : name, "pics[]": pics, "categoryId": categoryId, "tags[]": myArray, "price": price,
    					"promotion": promotion, "description": publishDescription, "extra1": extra1}, function(data) {
    						console.log(data);
    						if(data == "success") {
    							alert("add successfully");
    							
    							$("#productList").click();
    						}
    					});
			    		
    		});
    		
    		/*here is ads  */
    	
    	$("#sellerAd").click(function() {
    		
    		console.log("hehe");
    		
    		$.get("productList", function(data) {
    		
    			
    			var temp = eval("(" + data + ")");
    			
    			console.log(temp);
    			
    			var str = "";
    			for(var i = 0; i < temp.length; i++) {
					    				
    				str += "<option id='select_item_" + temp[i].id + "'>" + temp[i].name + "</option>";
    			}
    			
    			$("#item_select").html(str);
    		});
    	});
    	
    	$("#ad_confirm_btn").click(function() {
    	
    		var adName = $("#adName").val();
    		var itemId = $("#item_select option:selected").attr("id").substring(12);
    		
    		var startDay = $("#ad_start_day option:selected").val();
    		var startMonth = $("#ad_start_month option:selected").val();
    		var startYear = $("#ad_start_year option:selected").val();
    		
    		var endDay = $("#ad_end_day option:selected").val();
    		var endMonth = $("#ad_end_month option:selected").val();
    		var endYear = $("#ad_end_year option:selected").val();
    		
    		var start = startYear + "-" + startMonth + "-" + startDay;
    		var end = endYear + "-" + endMonth + "-" + endDay;
    		
    		
    		var picUrl = $("#pic-url").val();
    		/* console.log(start + ": " + end);
    		
    		console.log(itemId); */
    		
    		var weight = $("#weight").val();
    		var description = $("#ad_Desc").val();
    		
    		console.log(description);
    		if(adName == "" || weight == "" || description == "") {
    			alert("the attribute can't be null");
    			return;
    		}
    		else {
    			
    			$.post("addAd", {"pic-url": picUrl, "adName": adName, "itemId": itemId, "start": start, "end": end, "weight": weight, "description": description}, function(data) {
    				if(data == "success") {
    					alert("operate successfully");
    					$("#adName").val("");
    					$("#weight").val("");
    					$("#ad_Desc").val("");
    					$("#pic-url").val("");
    				}
    				
    			});	
    		}
    	});
    	
    });
    /* 
    
    
    	$("#record_select").change(function(){
    		var value = $("#record_select option:selected").val();
    		console.log(value);
			    		
    	}); */
    	
    	
    	
    	
    </script>
   
</head>
<body>
<%@ include file="include/header.jsp" %>

<div style="margin-top: 100px" id="mainContent">
    <div id="storeItemList">
        <div id="seller_center">
            <div class="left" id="sellerControl">
                <div id="sellerAvatar"><img id="sellerAvatarImg" src="images/avatar.jpg"></div>
                <ul>
                    <li class="sellerControlItem" data-target="#seller_basicInfo" id="basicInfo">
                        <span>Account Info</span>
                    </li>
                    <li class="sellerControlItem" data-target="#seller_security">
                        <span>Security</span>
                    </li>
                    
                    <c:choose>
                    	<c:when test="${sessionScope.b == 'true' }">
                    		<li class="sellerControlItem" data-target="#seller_publish" id="publishProduct">
                        		<span>Publish Product</span>
                    		</li>
                    		<li class="sellerControlItem" data-target="#seller_list" id="productList">
                      		  <span>ProductList</span>
                    		</li>
                 			  <!--  <li class="sellerControlItem" data-target="#seller_recycle">
                    		    <span>Recycle</span>
                 		   </li> -->
                  		  <li class="sellerControlItem" data-target="#seller_record" id="recordList">
                      		  <span>Record</span>
                  		  </li>
                    
                   		  <li class="sellerControlItem" data-target="#seller_ad" id="sellerAd">
                      		  <span>Ad</span>
                 		   </li>
                 		   <li class="sellerControlItem" data-target="seller_notification" id="sellerNotify">
                      		  <span>Notification</span>
                 		   </li>
                 	  	</c:when>
                    </c:choose>
                    
                 <!--    <li class="sellerControlItem" data-target="#seller_notification">
                        <span>Notification</span>
                    </li>
                    <li class="sellerControlItem" data-target="#seller_finance">
                        <span>Finance</span>
                    </li> -->
                </ul>
            </div>
            <div class="left sellerContent" id="seller_basicInfo">
                <%@ include file="seller/seller_basicInfo.jsp" %>
            </div>
            <div class="left sellerContent" id="seller_security">
                <%@ include file="seller/seller_security.jsp" %>
            </div>
            <div class="left sellerContent" id="seller_publish">
                <%@ include file="seller/seller_publish.jsp" %>
            </div>
            <div class="left sellerContent" id="seller_list">
                <%@ include file="seller/seller_list.jsp" %>
            </div>
            <div class="left sellerContent" id="seller_recycle">
                <%@ include file="seller/seller_recycle.jsp" %>
            </div>
            <div class="left sellerContent" id="seller_record">
                <%@ include file="seller/seller_record.jsp" %>
            </div>
            <div class="left sellerContent" id="seller_notification">
                <%@ include file="seller/seller_notification.jsp" %>
            </div>
            <div class="left sellerContent" id="seller_finance">
                <%@ include file="seller/seller_finance.jsp" %>
            </div>
            <div class="left sellerContent" id="seller_ad">
                <%@ include file="seller/seller_ad.jsp" %>
            </div>
        </div>
    </div>

</div>


<%@ include file="include/footer.jsp" %>


<script src="js/jquery-1.10.2.min.js" type="text/javascript"></script>
<script src="js/bootstrap.js" type="text/javascript"></script>

<script src="js/seller.js" type="text/javascript"></script>
<script src="js/common.js" type="text/javascript"></script>
</body>
</html>
