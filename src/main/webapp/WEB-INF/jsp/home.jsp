<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
Hi ${pageContext.request.userPrincipal.name}
<form action="/logout" method="post">
	<button type="submit">Logout</button>
</form>