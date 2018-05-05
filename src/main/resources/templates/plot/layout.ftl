<#macro head>
<!DOCTYPE html>
<html>
<head>
  <#include "/plot/head.ftl"/>
  <#nested/>
</head>
</#macro>
<!-- /header -->
<#macro body>
<body class="skin-black-light layout-top-nav">
<div class="wrapper">
	<#include "/plot/header.ftl"/>
	<#nested/>
	<#include "/plot/footer.ftl"/>
	<!--<div class="control-sidebar-bg"></div>-->
</div>
</#macro>

<!-- /body -->
<#macro javascript>
	<#include "/plot/js.ftl"/>
	<#nested/>
</body>
</html>
</#macro>