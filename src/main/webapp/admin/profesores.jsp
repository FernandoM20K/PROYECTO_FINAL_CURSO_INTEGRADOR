<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_PE"/>

<jsp:include page="../WEB-INF/templates/header_user.jsp"/>
<jsp:include page="../WEB-INF/templates/dashboard.jsp"/>

<div class="contenedord">
    <div class="titulo">
        <h4>Lista de Profesores</h4>
    </div>
    <div class="informacion notas">
        <div class="funciones-profesor">
            <div class="mensaje-export">
                <a href="${pageContext.request.contextPath}/admin/agregarProfesor.jsp" class="boton-verde-radio-inline"><i class="fa-solid fa-user-plus"></i><h6>Agregar Profesor</h6></a>
            </div>
            
            <h6>Total de Registros: ${totalProfesores}</h6>
        </div>

        <div class="tabla t-profesores">
            <table>
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Nombres</th>
                        <th>Apellidos</th>
                        <th>Dni</th>
                        <th>Edad</th>
                        <th>Genero</th>
                        <th>Celular</th>
                        <th>Email</th>
                        <th>Sueldo</th>
                        <th>Estado</th>
                        <th>Usuario</th>
                        <th>Opcion</th>
                    </tr>
                </thead>
                <tbody>
                    <!--INICIO ITERACION DE CADA ELEMENTO DE LA LISTA DE PROFESORES-->
                    <c:forEach var="profesor" items="${profesores}">
                        <tr>
                            <td>${profesor.idProfesor}</td>
                            <td>${profesor.nombres}</td>
                            <td>${profesor.apellidos}</td>
                            <td>${profesor.dni}</td>
                            <td>${profesor.edad}</td>
                            <td>${profesor.genero}</td>
                            <td>${profesor.celular}</td>
                            <td>${profesor.email}</td>
                            <td><fmt:formatNumber value="${profesor.sueldo}" type="currency"/></td>
                            <c:set var="estado" value="${profesor.estado}"/>
                            <c:choose>
                                <c:when test="${estado == 'Activo'}">
                                    <td class="verde-shadow">${profesor.estado}</td>
                                </c:when>
                                <c:when test="${estado == 'Retirado'}">
                                    <td class="rojo-shadow">${profesor.estado}</td>
                                </c:when>
                            </c:choose>

                            <c:set var="usuario" value="${profesor.idUsuario}"/>
                            <c:choose>
                                <c:when test="${usuario > 0}">
                                    <td class="verde-shadow"><h4 class="margin-1vw boton-verde-radio uppercase fw">Asignado</h4></td>
                                </c:when>
                                <c:otherwise>
                                    <td><a href="#" class="margin-1vw boton-rojo-radio"><h4 class="uppercase fw">Asignar</h4></a></td>
                                </c:otherwise>
                            </c:choose>
                            <td>
                                <a href="${pageContext.request.contextPath}/ControladorProfesor?accion=editar&idProfesor=${profesor.idProfesor}" class="boton-yellowgreen-radio-inline">
                                    <h4>
                                        <i class="fas fa-angle-double-right"> Editar</i>
                                    </h4>
                                </a>
                            </td>
                        </tr>
                    </c:forEach><!--FIN ITERACION DE CADA ELEMENTO DE LA LISTA DE PROFESORES-->
                </tbody>
            </table>
        </div>
    </div>
</div>

<jsp:include page="../WEB-INF/templates/footer_user.jsp"/>