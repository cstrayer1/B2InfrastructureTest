<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/bbNG" prefix="bbNG"%>

<%
	// set the url's to be used for links within this page

	pageContext.setAttribute("adminPanelUrl", "");
	pageContext.setAttribute("buildingBlocksUrl", "");
	pageContext.setAttribute("bbPluginsUrl", "");
%>

<bbNG:learningSystemPage>
	<bbNG:pageHeader>
		<bbNG:breadcrumbBar>
			<bbNG:breadcrumb href="${adminPanelUrl}">Administrator Panel</bbNG:breadcrumb>
			<bbNG:breadcrumb href="${buildingBlocksUrl}">Building Blocks</bbNG:breadcrumb>
			<bbNG:breadcrumb href="${bbPluginsUrl}">Installed Tools</bbNG:breadcrumb>
			<bbNG:breadcrumb>Settings</bbNG:breadcrumb>
		</bbNG:breadcrumbBar>

		<bbNG:pageTitleBar title="Settings Page">
			<c:out value="Tool Settings" />
		</bbNG:pageTitleBar>

	</bbNG:pageHeader>
	<div>
		UPDATE settings.jsp for this view!
	</div>
</bbNG:learningSystemPage>

