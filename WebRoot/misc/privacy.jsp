<%--
  Created by IntelliJ IDEA.
  User: Jack
  Date: 6/22/2014
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Online Store</title>
    <meta charset="utf-8" />
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="../css/misc/privacy.css" />
    <link rel="stylesheet" type="text/css" href="../css/common.css">
</head>
<body>
<%@ include file="../include/header.jsp" %>


<div id="categorybarDiv">
    <%@ include file="../include/categorybar.jsp" %>
</div>
<div id="mainContent">
    <div id="storeItemList">
        <div id="privacy">
            <div class="listitem">Our Pledge</div>
            <div class="listItemContent">We are committed to safeguarding the privacy of individuals with respect to personal data. We therefore make sure that our policies and practices in relation to the collection, use, retention, transfer and access of personal data comply with the requirements of the Personal Data (Privacy) Ordinance (Chapter 486) (the “Ordinance”) under the laws of Hong Kong.</div>
            <div class="listitem">Collection of Personally Identifiable Information</div>
            <div class="listItemContent">When you visit our website(s), we will record your visit only and will not collect any personally identifiable information (i.e. information that is about you and identifies you) from you unless otherwise stated. Cookies used (if any) in any part of our website will not be deployed for collecting personally identifiable information. For your information, Cookies are small computer files that can be stored in web surfers' computers for the purposes of obtaining configuration information and analysing web surfers' viewing habits. They can save you from registering again when re-visiting a web site and are commonly used to track your preferences in relation to the subject matter of the website. You may refuse to accept Cookies (by modifying the relevant Internet options or browsing preferences of your computer system), but to do so you may not be able to utilize or activate certain available functions in our websites.</div>
            <div class="listitem">Types of Personally Identifiable Information Collected</div>
            <div class="listItemContent">At times, you may be asked to provide your personally identifiable information (“Personal Data”) including, but not limited to, your name, gender, age, telephone number, fax number, home address, email address, credit card information, bank account number, education level, occupation, household income, interests and favourite activities, etc. in order to enjoy the service we offer. Specific purposes for which your Personal Data may be used are set out in our Personal Information Collection Statement under section 6 below, including the use of Personal Data for direct marketing.</div>
            <div class="listitem">Security</div>
            <div class="listItemContent">All personal data you provide to us is secured on our website with restricted access by authorized personnel only. Our online registration process uses the SSL protocol link for data transmission so as to protect your data via encrypting it in a secure format to ensure its privacy is maintained.</div>
            <div class="listitem">Enquiries</div>
            <div class="listItemContent">Should you have any enquiries concerning our Privacy Policy Statement, please feel free to contact our Customer Services Manager.
                <br>The address is as follows:
                <br>Customer Services Manager
                <br>PARKnSHOP
                <br>9th Floor, Watson House,
                <br>1-5 Wo Liu Hang Road, Fo Tan,
                <br>Sha Tin, New Territories
                <br>Email Address: <a href="mailto:care@parknshop.com">care@parknshop.com</a>
                <br>Please note that this Statement may be amended from time to time without prior notice. You are advised to check it on a regular basis.</div>
            <div class="listitem">Personal Information Collection Statement (“PICS”)</div>
            <div class="listItemContent">
                <ol style="padding:0; padding-left:15px"><li style="padding-bottom:10px;">As a PARKnSHOP customer, it may be necessary for you to provide us with your Personal Data when you apply to us and / or continue to subscribe with us for a service and / or product ("Services"). If your Personal Data is incomplete or incorrect, we may not be able to provide or continue to provide the Services to you.</li>           <li style="padding-bottom:10px;">We shall keep your Personal Data confidential at all times. Our policies and practices with respect to the collection, use, retention, disclosure, transfer, security and access of Personal Data will be in accordance with the laws of Hong Kong and are as set out in this PICS. <br></li><li style="padding-bottom:10px;">In this PICS, the following terms shall have the following meaning: <br>"Our affiliates" - means companies within Hutchison Whampoa Limited, which operate Retail Goods or Services business.<br>"Our subsidiaries" - means all the retail and manufacturing divisions operating under A. S. Watson Group offering goods or services to consumers, including health &amp; beauty products, food and groceries, water and beverages, wine and electronics and electrical appliances, all being related to the nature of business of PARKnSHOP, International, Fusion, Express, Fortress, Watsons, Great, Taste, Gourmet and SU-PA-DE-PA.<br>"Retail Goods or Services" - means sales of goods or provision of services in relation to any of the following (whether through physical or online channels): food &amp; beverages, restaurants, catering, groceries and household products, general merchandise, health &amp; beauty, pharmaceutical products, fragrance &amp; cosmetics, wine and liquor, cigarette and cigar, stationery, books and paper products, confectionary &amp; toys, clothing, shoes, baby products, pets products, fashion accessories, bags &amp; luggage,jewellery, watches, furniture, plants and accessories, sports &amp; leisure equipment, phones &amp; mobile devices, electronics &amp; electrical appliances, computer software and games, fuel, motor vehicle service. </li><li style="padding-bottom:10px;">You agree that all the Personal Data provided by you to us may be used and retained by us for the following purposes and for other purposes as may be agreed between you and us or required by law from time to time:<ol style="list-style-type: lower-alpha;margin-left:0px"><li>providing the Services;</li><li>analyzing, verifying and / or checking of your credit, payment and / or status in relation to the provision of the Services;</li><li>processing of any payment instructions, direct debit facilities and / or credit facilities requested by you;</li><li>enabling the daily operation of your account and / or the collection of amounts outstanding in your account in relation to the Services;</li><li>carrying out data sorting and analysis to enable us to better understand your characteristics and buying behavior and to provide other services better tailored to your needs, and to assist us in selecting good and services that are likely to be of interest to you;</li><li>providing you with regular communications from us with details of the Services and its benefits;</li><li>the normal management, operation and maintenance of the performance of the Services;</li><li>designing new, or improving existing, Services provided by us, our subsidiaries or our affiliates to you;</li><li>investigation of complaints, suspected suspicious transactions and research for service improvement;</li><li>prevention or detection of crime;</li><li>disclosure as required by law;</li><li>aggregated behavioral analysis.</li></ol></li><li style="padding-bottom:10px;">We would also like to use your Personal Data (including your name, telephone number, address and email address and other information provided to us when you register) for direct marketing to you (whether by post, email, phone, SMS or the like) in relation to:<ol style="list-style-type: lower-alpha;margin-left:0px">                <li>offers and promotions from us;</li>                <li>offers and promotions offered by our subsidiaries and our affiliates;</li>                <li>offers and promotions from other companies within Hutchison Whampoa Limited, in relation to telecommunication goods and/or services, e-commerce services, insurance products and services, hotel and tourism services and real property and related services;</li>                <li>other offers and promotions from the third party merchants that we cooperate with to provide benefits to our members in relation to the following types of products or services:<ol style="list-style-type: disc;"><li>Retail Goods or Services (as defined above)</li><li>Financial, insurance, banking and credit cards;</li><li>Transportation, travel and accommodation;</li><li>Sports, leisure, recreation and entertainment;</li><li>Telecommunications products and services;</li><li>E-commerce (including trading and payment platforms and online auctions)</li></ol></li>            </ol>Please note that we cannot so use your Personal Data unless we have received your consent. </li>                      <li style="padding-bottom:10px;">We may disclose and transfer (whether in Hong Kong or abroad) to our agents  or contractors under a duty of confidentiality to us who provide administrative, data processing, research and marketing, distribution, telecommunications, professional or other similar services to us and to any of our actual or proposed assignees or transferees of our rights with respect to you in connection with a merger, sale or transfer (whether of assets or shares), to use, hold, process or retain such Personal Data for the purposes mentioned in paragraphs 6.4 and 6.5 above on our behalf.</li>            <li style="padding-bottom:10px;">You have the right to:   <ol style="list-style-type: lower-roman;"><li>check whether we hold any of your Personal Data;</li><li>access your Personal Data held by us;</li><li>require us to correct any Personal Data which is inaccurate;</li><li>ascertain our policies and practices (from time to time) in relation to Personal Data and the types of Personal Data held by us.</li><li>opt out from receiving direct marketing materials from us at any time.</li></ol><p></p>  </li><li style="padding-bottom:10px;">Any requests in relation to the above shall be in writing (sent by post or email) and addressed to:  <br>Customer Services Manager<br>PARKnSHOP<br>9th Floor, Watson House,<br>1-5 Wo Liu Hang Road, Fo Tan,<br>Sha Tin, New Territories<br>Email Address: <a href="mailto:care@parknshop.com">care@parknshop.com</a><br>For enquiries, please contact PARKnSHOP Customer Hotline (026) 77563200.</li><li style="padding-bottom:10px;">In accordance with the Ordinance, we have the right to charge you a reasonable fee for the processing of any Personal Data access request.</li><li style="padding-bottom:10px;">Nothing in this PICS shall limit your rights under the Ordinance.</li></ol>
            </div>
        </div>
    </div>

</div>


<%@ include file="../include/footer.jsp" %>


<script src="../js/jquery-1.10.2.min.js" type="text/javascript"></script>
<script src="../js/bootstrap.js" type="text/javascript"></script>
<script src="../js/categorybar.js" type="text/javascript"></script>
<script src="../js/common.js" type="text/javascript"></script>
</body>
</html>