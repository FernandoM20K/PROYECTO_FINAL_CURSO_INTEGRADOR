<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../WEB-INF/templates/header_user.jsp"/>
<jsp:include page="../WEB-INF/templates/dashboard.jsp"/>

<div class="contenedord">
    <div class="titulo">
        <h4>Formulario de Agregacion de Usuario</h4>
    </div>
    <div class="informacion notas">
        <div class="funciones-profesor">
            <div class="mensaje-export">
                <a href="${pageContext.request.contextPath}/ControladorUsuario" class="boton-rojo-radio-inline"><i class="fa-solid fa-ban"></i><h6>Cancelar</h6></a>
            </div>
        </div>

        <div class="tabla">
            <form action="${pageContext.request.contextPath}/ControladorUsuario?accion=insertar" method="post">
                <div>
                    <label for="username">Nombre de Usuario</label>
                    <input type="text" id="username" name="username" class="block-100" required>
                </div>
                
                <div>
                    <label for="password">Password</label>
                    <input type="password" id="password" name="password" class="block-100" required>
                </div>

                <div>
                    <label for="password2">Vuelva a ingresar el Password</label>
                    <input type="password" id="password2" name="password2" class="block-100" required>
                </div>

                <div>
                    <label for="idRol">Rol</label>
                    <select id="idRol" name="idRol" class="block-100" required>
                        <option selected value=""></option>
                        <!--INICIO ITERACION DE CADA ELEMENTO DE LA LISTA DE ROLES-->
                        <c:forEach var="rol" items="${roles}">
                            <option value="${rol.idRol}">${rol.nombre}</option>
                        </c:forEach><!--FIN ITERACION DE CADA ELEMENTO DE LA LISTA DE ROLES-->
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