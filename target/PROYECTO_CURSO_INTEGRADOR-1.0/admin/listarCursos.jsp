<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../WEB-INF/templates/header_user.jsp"/>
<jsp:include page="../WEB-INF/templates/dashboard.jsp"/>

<div class="contenedord">
    <div class="titulo">
        <h4>Formulario de Agregacion de Cursos</h4>
    </div>
    <div class="informacion notas">
        <div class="funciones-profesor">
            <div class="mensaje-export">
                <a href="${pageContext.request.contextPath}/ControladorCurso" class="boton-rojo-radio-inline"><i class="fa-solid fa-ban"></i><h6>Cancelar</h6></a>
            </div>
        </div>

        <div class="tabla">
            <!--INICIO ITERACION DE CADA ELEMENTO DE LA LISTA DE CURSOS-->
            <c:forEach var="curso" items="${cursos}">
            <div class="vistaCurso">
                <div class="datosCurso">
                    <h3>Nombre del Curso: <span>${curso.nombreCurso}</span></h3>
                    <h3>Profesor: <span>${curso.nombresProfesor} ${curso.apellidosProfesor}</span></h3>
                </div>
                <div class="datosCurso">
                    <h4>Horas Semanales: <span>${curso.horasSemanales}</span></h4>
                    <h4>Duracion: <span>${curso.duracion} Semanas</span></h4>
                    <h4>Turno: <span>${curso.nombreTurno}</span></h4>
                </div>
                <a href="#"><h3>Seleccionar</h3></a>
                <button class="boton-oro-radio-inline"><h3>Seleccionar</h3></button>
            </div>
            </c:forEach><!--FIN ITERACION DE CADA ELEMENTO DE LA LISTA DE CURSOS-->
        </div>
    </div>
</div>

<jsp:include page="../WEB-INF/templates/footer_user.jsp"/>