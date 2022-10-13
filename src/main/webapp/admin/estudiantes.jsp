<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../WEB-INF/templates/header_user.jsp"/>
<jsp:include page="../WEB-INF/templates/dashboard.jsp"/>

<div class="contenedord">
    <div class="titulo">
        <h4>Lista de Estudiantes</h4>
    </div>
    <div class="informacion notas">
        <div class="funciones-profesor">
            <div class="mensaje-export">
                <a href="${pageContext.request.contextPath}/admin/agregarEstudiante.jsp" class="boton-verde-radio-inline"><i class="fa-solid fa-user-plus"></i><h6>Agregar Estudiante</h6></a>
            </div>
            
            <h6>Total de Estudiantes: ${totalEstudiantes}</h6>
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
                        <th>Fecha Ingreso</th>
                        <th>Fecha Retiro</th>
                        <th>Estado</th>
                        <th>Usuario</th>
                        <th>Opcion</th>
                    </tr>
                </thead>
                <tbody>
                    <!--INICIO ITERACION DE CADA ELEMENTO DE LA LISTA DE ESTUDIANTES-->
                    <c:forEach var="estudiante" items="${estudiantes}">
                        <tr>
                            <td>${estudiante.idEstudiante}</td>
                            <td>${estudiante.nombres}</td>
                            <td>${estudiante.apellidos}</td>
                            <td>${estudiante.dni}</td>
                            <td>${estudiante.edad}</td>
                            <td>${estudiante.genero}</td>
                            <td>${estudiante.celular}</td>
                            <td>${estudiante.email}</td>
                            <td>${estudiante.fechaIngreso}</td>
                            <td>${estudiante.fechaRetiro}</td>
                            <c:set var="estado" value="${estudiante.estado}"/>
                            <c:choose>
                                <c:when test="${estado == 'Activo'}">
                                    <td class="verde-shadow">${estudiante.estado}</td>
                                </c:when>
                                <c:when test="${estado == 'Retirado'}">
                                    <td class="rojo-shadow">${estudiante.estado}</td>
                                </c:when>
                            </c:choose>
                            <c:set var="usuario" value="${estudiante.idUsuario}"/>
                            <c:choose>
                                <c:when test="${usuario > 0}">
                                    <td class="verde-shadow"><h4 class="margin-1vw boton-verde-radio uppercase fw">Asignado</h4></td>
                                </c:when>
                                <c:otherwise>
                                    <td><a href="#" class="margin-1vw boton-rojo-radio"><h4 class="uppercase fw">Asignar</h4></a></td>
                                </c:otherwise>
                            </c:choose>
                            <td>
                                <a href="${pageContext.request.contextPath}/ControladorEstudiante?accion=editar&idEstudiante=${estudiante.idEstudiante}" class="boton-yellowgreen-radio-inline">
                                    <h4>
                                        <i class="fas fa-angle-double-right"> Editar</i>
                                    </h4>
                                </a>
                            </td>
                        </tr>
                    </c:forEach><!--FIN ITERACION DE CADA ELEMENTO DE LA LISTA DE ESTUDIANTES-->
                </tbody>
            </table>
        </div>
    </div>
</div>

<jsp:include page="../WEB-INF/templates/footer_user.jsp"/>