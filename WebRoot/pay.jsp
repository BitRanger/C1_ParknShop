<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Online Store</title>
    <meta charset="utf-8">
    <meta name="viewport" content="initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/index.css">
    <link rel="stylesheet" type="text/css" href="css/pay.css">
    <link rel="stylesheet" type="text/css" href="css/common.css">
</head>
<body>
<%@ include file="include/header.jsp" %>


<div id="categorybarDiv">
    <%@ include file="include/categorybar.jsp" %>
</div>
<div id="mainContent">
    <div id="storeItemList">
        <div class="payTitleBar">
            <div class="left payTitle">
                Please Choose Payment
            </div>
            <div class="right" style="padding-top: 6px">
                <a class="pay_link" href="conformOrder.jsp">Back</a>
            </div>
        </div>
        <div id="payList">
            <form id="payListForm" action="submitPayment" method="post">
            	<input type="hidden" name="psOrderId" value="<%=request.getParameter("orderId")%>">
                <div class="payMethodItem">
                    <div class="payMethodTitle">Cash on Delivery</div>
                    <div class="payMethodContent">
                        <div class="payListItem">
                            <input type="radio" name="payment">By Cash
                        </div>
                        <div class="payListItem">
                            <input type="radio" name="payment">Pos Machine
                        </div>
                    </div>
                </div>
                <div class="payMethodItem">
                    <div class="payMethodTitle">The Third Payment (In 12 hours)</div>
                    <div class="payMethodContent">
                        <div class="payListItem">
                            <input type="radio" name="payment">
                            Use your Alipay or Tenpay account to pay the order
                            <div class="selectDiv">
                                <select>
                                    <option>Alipay</option>
                                    <option>Tenpay</option>
                                </select>
                            </div>
                        </div>
                        <div class="payListItem">
                            <input type="radio" name="payment">
                            By Paypal
                        </div>
                    </div>
                </div>
                <div class="payMethodItem">
                    <div class="payMethodTitle">Online Bank (In 12 hours)</div>
                    <div class="payMethodContent">
                        <div class="payListItem">
<<<<<<< HEAD
                            <input type="radio" name="payment" id="bankSelectInput">
=======
                            <input type="radio" name="payment">
>>>>>>> c7c78cd9f37d4662e95dd95bf4d4054fc2ec8e79
                            Go to the your online bank to pay the order. (Notice: you must have an online bank account. And the
                            payment amount is limited)
                            <div class="selectDiv">
                                <select>
                                    <option>中信银行</option>
                                    <option>中国工商银行</option>
                                    <option>中国银行</option>
                                    <option>中国农业银行</option>
                                    <option>中国建设银行</option>
                                    <option>交通银行</option>
                                    <option>华夏银行</option>
                                    <option>浦东发展银行</option>
                                    <option>中国银行</option>
                                    <option>兴业银行</option>
                                    <option>民生银行</option>
                                    <option>平安银行</option>
                                    <option>招商银行</option>
                                    <option>中国光大银行</option>
                                    <option>中国邮政储蓄银行</option>
                                </select>
                            </div>
<<<<<<< HEAD
                             <div id="bankExtra">
                                <div id="bankNumberDiv">
                                    <input style="width: 280px" class="common_input" placeholder="Bank Number">
                                </div>
                                <div>
                                    <button class="common_btn">Get Code</button>
                                </div>
                                <div>
                                    <input style="width: 140px" class="common_input" type="text" placeholder="verification code">
                                </div>
                            </div>
=======
>>>>>>> c7c78cd9f37d4662e95dd95bf4d4054fc2ec8e79
                        </div>
                    </div>
                </div>
                <div class="payMethodItem">
                    <div class="payMethodTitle">Credit Card</div>
                    <div class="payMethodContent">
                        <div class="payListItem">
                            <input type="radio" name="payment">Use Your Credit Card
                            <div id="creditCardDiv">
                                <ul>
                                    <li><input class="common_input" type="text" name="credit_name" placeholder="Card Name"></li>
                                    <li><input class="common_input" type="text" name="credit_number" placeholder="Card Number"></li>
                                    <select>
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
                                    <select>
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
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="payMethodItem">
                    <div class="payMethodTitle">Other Payment</div>
                    <div class="payMethodContent">
                        <div class="payListItem">
                            <input type="radio" name="payment">Gift Card and Promotion Code
                            <div id="giftCardDiv">
                                <input class="common_input" type="text" placeholder="Card Code">
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
        <div style="margin-top: 20px; height: 30px">
            <a href="#" id="payDoneBtn" data-toggle="modal" data-target="#payDoneModal">Done</a>
        </div>
        <div class="modal fade" id="payDoneModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">Succeed !</h4>
                    </div>
                    <div class="modal-body"> Thank you for buying our books !<br>
<<<<<<< HEAD
                        We'll take care your order as soon as possible! Enjoy Shopping!
=======
                        We'll take care your order as soon as possible! Enjoy Shopping ! div>
>>>>>>> c7c78cd9f37d4662e95dd95bf4d4054fc2ec8e79
                        <div class="modal-footer">
                            <button type="button" class="common_btn" id="payDoneModalBtn" data-dismiss="modal">Close</button>
                        </div>
                    </div>
                    <!-- /.modal-content -->
                </div>
                <!-- /.modal-dialog -->
            </div>
        </div>
    </div>
</div>




<%@ include file="include/footer.jsp" %>

<script src="js/jquery-1.10.2.min.js" type="text/javascript"></script>
<script src="js/bootstrap.js" type="text/javascript"></script>
<script src="js/categorybar.js" type="text/javascript"></script>
<script src="js/common.js" type="text/javascript"></script>
<script>
    $('#payDoneModal').on('hidden.bs.modal', function (e) {
        document.getElementById('payListForm').submit();
    });
</script>
</body>
</html>
