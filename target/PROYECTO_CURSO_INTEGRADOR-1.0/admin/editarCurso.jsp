<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../WEB-INF/templates/header_user.jsp"/>
<jsp:include page="../WEB-INF/templates/dashboard.jsp"/>

<div class="contenedord">
    <div class="titulo">
        <h4>Formulario de Edicion de Cursos</h4>
    </div>
    <div class="informacion notas">
        <div class="funciones-profesor">
            <div class="mensaje-export">
                <a href="${pageContext.request.contextPath}/ControladorCurso" class="boton-rojo-radio-inline"><i class="fa-solid fa-ban"></i><h6>Cancelar</h6></a>
            </div>
        </div>

        <div class="tabla">
            <form action="${pageContext.request.contextPath}/ControladorCurso?accion=modificar&idCurso=${curso.idCurso}" method="post">
                <div>
                    <label for="nombreCurso">Nombre del Curso</label>
                    <input type="text" id="nombreCurso" name="nombreCurso" class="block-100" required value="${curso.nombreCurso}">
                </div>
                
                <div>
                    <label for="horasSemana">Horas a la Semana</label>
                    <input type="number" id="horasSemana" name="horasSemana" class="block-100" required value="${curso.horasSemanales}">
                </div>

                <div>
                    <label for="duracionSemanas">Duracion en Semanas</label>
                    <input type="number" id="duracionSemanas" name="duracionSemanas" class="block-100" required value="${curso.duracion}">
                </div>

                <div>
                    <label for="idProfesor">Profesor</label>
                    <select id="idProfesor" name="idProfesor" class="block-100" required value="${curso.idProfesor}">
                        <option selected value=""></option>
                        <!--INICIO ITERACION DE CADA ELEMENTO DE LA LISTA DE PROFESORES-->
                        <c:forEach var="profesor" items="${profesores}">
                            <option value="${profesor.idProfesor}">${profesor.nombres} ${profesor.apellidos}</option>
                        </c:forEach><!--FIN ITERACION DE CADA ELEMENTO DE LA LISTA DE PROFESORES-->
                    </select>
                </div>

                <div>
                    <label for="idTurno">Turno</label>
                    <select id="idTurno" name="idTurno" class="block-100" required>
                        <option selected value=""></option>
                        <!--INICIO ITERACION DE CADA ELEMENTO DE LA LISTA DE TURNOS-->
                        <c:forEach var="turno" items="${turnos}">
                            <option value="${turno.idTurno}">${turno.turno}</option>
                        </c:forEach><!--FIN ITERACION DE CADA ELEMENTO DE LA LISTA DE TURNOS-->
                    </select>
                </div>
    
                <div class="cont-registro">
                    <button type="submit" class="boton-transparente btn-crear"><i class="fa-solid fa-dragon"></i> Guardar Informacion</button>
                </div>
            </form>
        </div>
    </div>
</div>

<jsp:include page="../WEB-INF/templates/footer_user.jsp"/>