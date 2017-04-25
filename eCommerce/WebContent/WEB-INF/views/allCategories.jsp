

<div id="content">
	<div class="container">
	
		<div ng-controller="MenuController" ng-init="getCategories()">





<div class="box">


<div class="flex-container">
  <div class="flex-item" ng-repeat="item in categoryList">{{item.name}}
  
    <ul class = "list-group">
    
     <li class = "list-group-item" ng-repeat="subitem in item.children">
     <a href = "" >
         {{subitem.name}}</a> 
    
   <!--  <div class="flex-item"  > {{subitem.name}} -->
  
  
   
      <ul class = "list-group">
      <li class = "list-group-item" ng-repeat="lastsubitem in subitem.children"><a href = "#/category/{{lastsubitem.categoryID}}/0" >
        {{lastsubitem.name}}</a></li>
     
   </ul>
   </li>
  </ul>
  
  
  </div>
  
  
  
  </div>
  
</div>
<!-- 

<div class = "list-group flex-item" ng-repeat="item in categoryList">
   <a href = "#" class = "list-group-item active">
      <h4 class = "list-group-item-heading">
         {{item.name}}
      </h4>
   </a>
   
   <a href = "#" class = "list-group-item" ng-repeat="subitem in item.children">
      <h4 class = "list-group-item-heading">
        {{subitem.name}}
      </h4>
      
      <p class = "list-group-item-text" ng-repeat="lastsubitem in subitem.children">
        {{lastsubitem.name}}
      </p>
   </a>
   
   
   
</div> -->





















<!-- 




		<div ng-controller="MenuController" ng-init="getCategories()">

	<div class="navbar navbar-default yamm" role="navigation" id="navbar">
	
    <div class="collapse navbar-collapse" >
      <ul class="nav navbar-nav">
    
        <li  ng-repeat="item in categoryList">
        <h4> {{item.name}}</h4>
          <ul ng-if="item.children">
               <li>
			<div class="yamm-content" >
					<div class="row">
						
												<div ng-repeat="subitem in item.children" class="col-sm-9">
													<h5>
														{{subitem.name}}
													</h5>

													<ul ng-if="subitem.children">
													<li ng-repeat="lastsubitem in subitem.children">
													
													<a
																href="#/category/{{lastsubitem.categoryID}}/0">
																		{{lastsubitem.name}}</a>
																		</li>
													</ul>
												</div>				
    
    </div></div></li>
          </ul>
        </li>
      </ul>

    </div>/.navbar-collapse
		
		

			/.nav-collapse

		</div>
		/.container
		
	</div> -->




			</div>
			<!-- box ends here -->
	</div>
</div>
</div>