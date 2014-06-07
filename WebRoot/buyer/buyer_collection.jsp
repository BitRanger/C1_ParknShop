<%--
  Created by IntelliJ IDEA.
  User: Jack
  Date: 5/31/2014
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>




<% for(int i = 0; i < 4; i++) { %>
    <div class="collectionItemRow">
    <% for(int j = 0; j < 3; j++) { %>
        <div class="collectionItem">
            <a href="detail.jsp"><img width="180px" src="images/clothes_demo.jpg" alt="..."></a>
            <div class="collectionItemDesc">
                <h5><a class="collectionItemLink" href="#">Spring break graphic tee, Men T-shirt</a> </h5>
                <p>Price: $50.00</p>
            </div>
        </div>
    <% } %>
    </div>
<% } %>