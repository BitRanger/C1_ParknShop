<div id="attracting">
    <div id="attractingLeft">
        <div id="attractingBigShow">
            <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="1" class=""></li>
                    <li data-target="#carousel-example-generic" data-slide-to="2" class=""></li>
                    <li data-target="#carousel-example-generic" data-slide-to="3" class=""></li>
                </ol>
                <div class="carousel-inner">
                    <div class="item">
                        <img src="images/attracting1.jpg"/>
                    </div>
                    <div class="item active left">
                        <img src="images/attracting2.jpg"/>
                    </div>
                    <div class="item next left">
                        <img src="images/attracting3.jpg"/>
                    </div>
                    <div class="item next left">
                        <img src="images/attracting4.jpg"/>
                    </div>
                </div>
                <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left"></span>
                </a>
                <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right"></span>
                </a>
            </div>
        </div>
        <div id="attracting_cutting">
            <div id="discount_title">
                    <span id="discount_title_left">
                        Big Deal on Today
                    </span>
                    <span id="discount_title_right">
                        Hong Kong's Leading Discount Center
                    </span>
            </div>
            <div id="discount_areaWrapper">
                <div id="discount_area">
                    <div class="discount_area_list">
                        <% for(int i = 0; i < 5; i++) { %>
                        <div class="discountItem">
                            <img class="discountItemImg" src="images/discount_ex1.jpg"/>
                        </div>
                        <% } %>
                    </div>
                    <div class="discount_area_list">
                        <% for(int i = 0; i < 5; i++) { %>
                        <div class="discountItem">
                            <img class="discountItemImg" src="images/discount_ex2.jpg"/>
                        </div>
                        <% } %>
                    </div>
                    <div class="discount_area_list">
                        <% for(int i = 0; i < 5; i++) { %>
                        <div class="discountItem">
                            <img class="discountItemImg" src="images/discount_ex3.jpg"/>
                        </div>
                        <% } %>
                    </div>
                </div>
                <a class="discount_navBtn" id="discount_leftBtn">
                    <span class="glyphicon glyphicon-chevron-left"></span>
                </a>
                <a class="discount_navBtn" id="discount_rightBtn">
                    <span class="glyphicon glyphicon-chevron-right"></span>
                </a>
            </div>
        </div>
    </div>

    <div id="attractingRight">
        <img style="width: 275px" src="images/imgad.gif"/>
        <img style="margin-top: 20px; width: 275px" src="images/imgad2.jpg"/>
        <span id="ad_span">
            <a id="ad_link" >Advertisement</a>
        </span>
    </div>
</div>