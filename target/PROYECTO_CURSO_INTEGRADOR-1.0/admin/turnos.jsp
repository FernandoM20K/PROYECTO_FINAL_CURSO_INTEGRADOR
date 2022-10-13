<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../WEB-INF/templates/header_user.jsp"/>
<jsp:include page="../WEB-INF/templates/dashboard.jsp"/>

<div class="contenedord">
    <div class="titulo">
        <h4>Lista de Categorias de Turnos</h4>
    </div>
    <div class="informacion notas">
        <div class="funciones-profesor">
            <div class="mensaje-export">
                <a href="${pageContext.request.contextPath}/agregarTurno.jsp" class="boton-verde-radio-inline"><i class="fa-solid fa-user-plus"></i><h6>Agregar Turno</h6></a>
            </div>
            
            <h6>Total de Registros: ${totalTurnos}</h6>
        </div>

        <div class="tabla t-profesores">
            <table>
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Turno</th>
                    </tr>
                </thead>
                <tbody>
                    <!--INICIO ITERACION DE CADA ELEMENTO DE LA LISTA DE TURNOS-->
                    <c:forEach var="turno" items="${turnos}">
                        <tr>
                            <td>${turno.idturno}</td>
                            <td>${turno.turno}</td>
                        </tr>
                    </c:forEach><!--FIN ITERACION DE CADA ELEMENTO DE LA LISTA DE TURNOS-->
                </tbody>
            </table>
        </div>
    </div>
</div>

<jsp:include page="../WEB-INF/templates/footer_user.jsp"/>