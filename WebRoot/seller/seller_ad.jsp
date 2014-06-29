<%@page import="com.bitranger.parknshop.common.ads.PsPromotItem"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<ul id="ad_nav" class="nav nav-tabs">
    <li ><a href="#ad_publish" data-toggle="tab">Add ad</a></li>
    <li ><a href="#ad_view" data-toggle="tab" id="ad_view_all">View All</a></li>
</ul>

<div class="tab-content">
	<div class="tab-pane" id="ad_publish">
	
    <form id="ad_form">
        <div>
            <label class="common_label">Ad Name</label>
            <input class="common_input" type="text" name="adName" id="adName">
        </div>
        <div>
            <label class="common_label">Target</label>
            <!-- <input id="chooseTargetBtn" class="common_btn" type="button" value="Please choose"> -->
            <select id="item_select">
            	
            </select>
        </div>
        <div style="height: 40px;margin-top: 10px;">
            <div class="left ad_time" style="margin-right: 80px">
                <label class="common_label">Ad Start</label>
                <select id="ad_start_day" class="">
                    <option>01</option>
                    <option>02</option>
                    <option>03</option>
                    <option>04</option>
                    <option>05</option>
                    <option>06</option>
                    <option>07</option>
                    <option>08</option>
                    <option>09</option>
                    <option>10</option>
                    <option>11</option>
                    <option>12</option>
                    <option>13</option>
                    <option>14</option>
                    <option>15</option>
                    <option>16</option>
                    <option>17</option>
                    <option>18</option>
                    <option>19</option>
                    <option>20</option>
                    <option>21</option>
                    <option>22</option>
                    <option>23</option>
                    <option>24</option>
                    <option>25</option>
                    <option>26</option>
                    <option>27</option>
                    <option>28</option>
                </select>
                <select id="ad_start_month">
                    <option>01</option>
                    <option>02</option>
                    <option>03</option>
                    <option>04</option>
                    <option>05</option>
                    <option>06</option>
                    <option>07</option>
                    <option>08</option>
                    <option>09</option>
                    <option>10</option>
                    <option>11</option>
                    <option>12</option>
                </select>
                <select id="ad_start_year">
                    <option>2014</option>
                    <option>2015</option>
                    <option>2016</option>
                    <option>2017</option>
                    <option>2018</option>
                    <option>2019</option>
                    <option>2020</option>
                    <option>2021</option>
                    <option>2022</option>
                    <option>2023</option>
                    <option>2024</option>
                    <option>2025</option>
                    <option>2026</option>
                    <option>2027</option>
                    <option>2028</option>
                    <option>2029</option>
                    <option>2030</option>
                    <option>2031</option>
                    <option>2032</option>
                    <option>2033</option>
                    <option>2034</option>
                    <option>2035</option>
                    <option>2036</option>
                    <option>2037</option>
                    <option>2038</option>
                </select>
            </div>
            <div class="left ad_time">
                <label class="common_label" style="width: 50px">Ad End</label>
                <select id="ad_end_day">
                    <option>01</option>
                    <option>02</option>
                    <option>03</option>
                    <option>04</option>
                    <option>05</option>
                    <option>06</option>
                    <option>07</option>
                    <option>08</option>
                    <option>09</option>
                    <option>10</option>
                    <option>11</option>
                    <option>12</option>
                    <option>13</option>
                    <option>14</option>
                    <option>15</option>
                    <option>16</option>
                    <option>17</option>
                    <option>18</option>
                    <option>19</option>
                    <option>20</option>
                    <option>21</option>
                    <option>22</option>
                    <option>23</option>
                    <option>24</option>
                    <option>25</option>
                    <option>26</option>
                    <option>27</option>
                    <option>28</option>
                </select>
                <select id="ad_end_month">
                    <option>01</option>
                    <option>02</option>
                    <option>03</option>
                    <option>04</option>
                    <option>05</option>
                    <option>06</option>
                    <option>07</option>
                    <option>08</option>
                    <option>09</option>
                    <option>10</option>
                    <option>11</option>
                    <option>12</option>
                </select>
                <select id="ad_end_year">
                    <option>2014</option>
                    <option>2015</option>
                    <option>2016</option>
                    <option>2017</option>
                    <option>2018</option>
                    <option>2019</option>
                    <option>2020</option>
                    <option>2021</option>
                    <option>2022</option>
                    <option>2023</option>
                    <option>2024</option>
                    <option>2025</option>
                    <option>2026</option>
                    <option>2027</option>
                    <option>2028</option>
                    <option>2029</option>
                    <option>2030</option>
                    <option>2031</option>
                    <option>2032</option>
                    <option>2033</option>
                    <option>2034</option>
                    <option>2035</option>
                    <option>2036</option>
                    <option>2037</option>
                    <option>2038</option>
                </select>
            </div>
        </div>
        <div>
            <label class="common_label">Weight</label>
            <input class="common_input" type="text" id="weight" name="weight">
        </div>
       <!--  <div>
            <label class="common_label left">Image</label>
            <div id="uploadDiv">
                <div id="uploadImages"></div>
                <div id="upload">
                    <a href="javascript:void(0)" onclick="uploadImage()">
                        <img src="images/upload.JPG">
                    </a>
                    <input style="display: none" id="imgFile" type="file"
                           name="imgFile" onchange="previewImage(this)">
                </div>
            </div>
        </div> -->

		<div>
            <label class="common_label">Picture Url</label>
            <input class="common_input" type="text" name="pic-url" id="pic-url"></input>
        </div>
        
        <div style="margin-top: 20px">
            <label class="common_label">Ad Description</label>
            <textarea id="ad_Desc"></textarea>
        </div>

        
        <div style="margin-left: 90px; margin-top: 30px">
            <input style="width: 80px" class="common_btn" id="ad_confirm_btn" value="Confirm">
        </div>
    </form>
    </div>
     <div class="tab-pane" id="ad_view">
        <table id="ad_listTable">
            <tr id="ad_listTableHeader">
                <th>ID</th>
                <th>Content</th>
                <th>Clicks</th>
                <th>Operation</th>
            </tr>
           <%--  <% 
            List<PsPromotItem> ad_list = (List<PsPromotItem>)request.getAttribute("ad_list");
            for(int i = 0; i < ad_list.size(); i++) { 
            	PsPromotItem ad = ad_list.get(i);
            %> --%>
            <c:forEach items="${ad_list}" var="prompt">
            	<tr class="ad_listRow">
                <td>
                    <span>${prompt.id}</span>
                </td>
                <td>
                    <div class="left ad_listItemImgDiv">
                        <img src="${prompt.picUrl }">
                    </div>
                    <div class="left ad_listItemDescDiv">
                    	${prompt.description}
                    </div>
                </td>
                <td>
                    <span>${prompt.psAdItem.numFetched}</span>
                </td>
                <td>
                    <span class="operation">Modify</span>
                    <span class="operation">Delete</span>
                </td>
            	</tr>
            </c:forEach>
            
            
        </table>
        </div>
    
</div>
