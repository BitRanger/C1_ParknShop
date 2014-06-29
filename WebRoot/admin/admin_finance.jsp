<%--
  Created by IntelliJ IDEA.
  User: Jack
  Date: 6/19/2014
  Time: 21:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <div style="height: 40px;margin-top: 10px;">
        <div class="left finance_time" style="margin-right: 80px">
            <label class="common_label">Start</label>
            <select id="finance_start_day" class="">
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
            <select id="finance_start_month">
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
            <select id="finance_start_year">
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
        <div class="left finance_time">
            <label class="common_label" style="width: 50px">End</label>
            <select id="finance_end_day">
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
            <select id="finance_end_month">
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
            <select id="finance_end_year">
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
    <div >
        <button style="margin-left: 95px" class="common_btn">Confirm</button>
    </div>
    <div id="finance_spec">
        <div id="finance_spec_left">
            <h3 style="font-size: 18px">The total transactions is 
            <% Object obj = request.getAttribute("count_orders");
            	if (obj == null) {
            		out.print(3);
            	} else {
            		out.print(obj);
            	}
            %>.
            Amount of Money: <%= request.getAttribute("tnx_volumn") %>
             Among them: </h3>
            <ul>
                <li class="financeItem">
                    <span id="financeItem1"></span>
                    <span>Revenue from transactions: <%= request.getAttribute("revenue_orders") %>, <%= request.getAttribute("ratio_order") %></span>
                </li>
                <li class="financeItem">
                    <span id="financeItem2"></span>
                    <span>Revenue from advertising:  <%= request.getAttribute("revenue_ads") %>, <%= request.getAttribute("ratio_ad") %></span>
                </li>
                <li class="financeItem">
                    <span id="financeItem3"></span>
                    <span>Others: 0.0%</span>
                </li>
            </ul>
        </div>
        <div id="finance_spec_right">
            <canvas id="canvas" height="240" width="240" style="width: 240px; height: 240px;"></canvas>
            <script>
                var pieData = [
                    {
                        value: 
                        <% double db = (((Double)request.getAttribute("ratio_order")) * 100);
                    if (db < 0.0001) {
                    	db = 10;
                    }
                    out.print(db);
                    	%>,
                        
                        color:"#F38630"
                    },
                    {
                        value:
                        <% double db2 = (((Double)request.getAttribute("ratio_ad")) * 100);
                        if (db < 0.0001) {
                        	db = 10;
                        }
                        out.print(db2);
                        %>
                        color : "#E0E4CC"
                    },
                    {
                        value : 0,
                        color : "#69D2E7"
                    }
                ];

                var myPie = new Chart(document.getElementById("canvas").getContext("2d")).Pie(pieData);

            </script>
        </div>
    </div>
</div>