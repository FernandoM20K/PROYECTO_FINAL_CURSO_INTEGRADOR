<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../WEB-INF/templates/header_user.jsp"/>
<jsp:include page="../WEB-INF/templates/dashboard.jsp"/>

<div class="contenedord">
    <div class="titulo">
        <h4>Lista de Usuarios</h4>
    </div>
    <div class="informacion notas">
        <div class="funciones-profesor">
            <div class="mensaje-export">
                <a href="${pageContext.request.contextPath}/ControladorUsuario?accion=agregar" class="boton-verde-radio-inline"><i class="fa-solid fa-user-plus"></i><h6>Agregar Usuario</h6></a>
            </div>
            
            <h6>Total de Usuarios: ${totalUsuarios}</h6>
        </div>

        <div class="tabla t-profesores">
            <table>
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Nombre de Usuario</th>
                        <th>Rol</th>
                        <th>Opcion</th>
                    </tr>
                </thead>
                <tbody>
                    <!--INICIO ITERACION DE CADA ELEMENTO DE LA LISTA DE PRODUCTOS-->
                    <c:forEach var="usuario" items="${usuarios}">
                        <tr>
                            <td>${usuario.idUsuario}</td>
                            <td>${usuario.username}</td>
                            <td>${usuario.nombreRol}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/ControladorUusario?accion=editar&idUsuario=${usuario.idUsuario}" class="boton-yellowgreen-radio-inline">
                                    <h4>
                                        <i class="fas fa-angle-double-right"> Editar</i>
                                    </h4>
                                </a>
                            </td>
                        </tr>
                    </c:forEach><!--FIN ITERACION DE CADA ELEMENTO DE LA LISTA DE PRODUCTOS-->
                </tbody>
            </table>
        </div>
    </div>
</div>

<jsp:include page="../WEB-INF/templates/footer_user.jsp"/>