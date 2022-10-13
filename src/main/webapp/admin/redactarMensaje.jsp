<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../WEB-INF/templates/header_user.jsp"/>
<jsp:include page="../WEB-INF/templates/dashboard.jsp"/>

<div class="contenedord">
    <div class="titulo">
        <h4>Redaccion de Envio de Mensajes</h4>
    </div>
    <div class="informacion notas">
        <div class="funciones-profesor">
            <div class="mensaje-export">
                <a href="${pageContext.request.contextPath}/ControladorMensaje" class="boton-rojo-radio-inline"><i class="fa-solid fa-ban"></i><h6>Cancelar</h6></a>
            </div>
        </div>

        <div class="tabla mensaje">
            <form action="${pageContext.request.contextPath}/ControladorMensaje?accion=insertar" method="post">
                <div>
                    <label for="titulo">Titulo</label>
                    <input type="text" id="titulo" name="titulo" class="block-100" required>
                </div>

                <div>
                    <label for="texto">Mensaje</label>
                    <textarea id="texto" name="mensaje" class="block-100" required></textarea>
                </div>
                
                <div class="mitad">
                    <div class="seleccion-profesor">
                        <label for="idProfesor">Persona a Enviar Mensaje</label>
                        <select id="idProfesor" name="idProfesor" required class="block-100">
                            <option selected value=""></option>
                            <!--INICIO ITERACION DE CADA ELEMENTO DE LA LISTA DE PROFESORES-->
                            <c:forEach var="profesor" items="${profesores}">
                                <option value="${profesor.idProfesor}">${profesor.nombre} ${profesor.apellido}</option>
                            </c:forEach><!--FIN ITERACION DE CADA ELEMENTO DE LA LISTA DE PROFESORES-->
                        </select>
                    </div>

                    <div>
                        <label for="archivo">Enviar Archivo (Opcional)</label>
                        <input type="file" id="archivo" name="archivo" class="block-100">
                    </div>
                </div>
            
                <div class="opciones-envio">
                    <button type="submit" class="boton-verde-radio-inline"><i class="fa-solid fa-paper-plane"></i>Enviar Mensaje</button>
                </div>
            </form>
        </div>
    </div>
</div>

<jsp:include page="../WEB-INF/templates/footer_user.jsp"/>