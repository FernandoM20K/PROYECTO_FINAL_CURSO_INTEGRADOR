<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../WEB-INF/templates/header_user.jsp"/>
<jsp:include page="../WEB-INF/templates/dashboard.jsp"/>

<div class="contenedord">
    <div class="titulo">
        <h4>Lista de Cursos</h4>
    </div>
    <div class="informacion notas">
        <div class="funciones-profesor">
            <div class="mensaje-export">
                <a href="${pageContext.request.contextPath}/ControladorCurso?accion=agregar" class="boton-verde-radio-inline"><i class="fa-solid fa-user-plus"></i><h6>Agregar Curso</h6></a>
            </div>
            
            <h6>Total de Cursos: ${totalCursos}</h6>
        </div>

        <div class="tabla t-profesores">
            <table>
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Curso</th>
                        <th>Horas X Semana</th>
                        <th>Duracion Semanas</th>
                        <th>Turno</th>
                        <th>Profesor</th>
                        <th>Opcion</th>
                    </tr>
                </thead>
                <tbody>
                    <!--INICIO ITERACION DE CADA ELEMENTO DE LA LISTA DE CURSOS-->
                    <c:forEach var="curso" items="${cursos}">
                        <tr>
                            <td>${curso.idCurso}</td>
                            <td>${curso.nombreCurso}</td>
                            <td>${curso.horasSemanales}</td>
                            <td>${curso.duracion}</td>
                            <td>${curso.nombreTurno}</td>
                            <td>${curso.nombresProfesor} ${curso.apellidosProfesor}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/ControladorCurso?accion=editar&idCurso=${curso.idCurso}" class="boton-yellowgreen-radio-inline">
                                    <h4>
                                        <i class="fas fa-angle-double-right"> Editar</i>
                                    </h4>
                                </a>
                            </td>
                        </tr>
                    </c:forEach><!--FIN ITERACION DE CADA ELEMENTO DE LA LISTA DE CURSOS-->
                </tbody>
            </table>
        </div>
    </div>
</div>

<jsp:include page="../WEB-INF/templates/footer_user.jsp"/>