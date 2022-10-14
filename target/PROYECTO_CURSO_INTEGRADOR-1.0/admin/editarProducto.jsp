<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../WEB-INF/templates/header_user.jsp"/>
<jsp:include page="../WEB-INF/templates/dashboard.jsp"/>

<div class="contenedord">
    <div class="titulo">
        <h4>Formulario de Edicion de Productos</h4>
    </div>
    <div class="informacion notas">
        <div class="funciones-profesor">
            <div class="mensaje-export">
                <a href="${pageContext.request.contextPath}/ControladorProducto" class="boton-rojo-radio-inline"><i class="fa-solid fa-ban"></i><h6>Cancelar</h6></a>
            </div>
        </div>

        <div class="tabla">
            <form action="${pageContext.request.contextPath}/ControladorProducto?accion=modificar&idProducto=${producto.idProducto}" method="post">
                <div>
                    <label for="descripcion">Descripcion</label>
                    <input type="text" id="descripcion" name="descripcion" class="block-100" required value="${producto.descripcion}">
                </div>
                
                <div>
                    <label for="stock">Stock</label>
                    <input type="number" id="stock" name="stock" class="block-100" required value="${producto.stock}">
                </div>

                <div>
                    <label for="idCategoria">Categoria</label>
                    <select id="idCategoria" name="idCategoria" class="block-100" required value="${producto.categoria}">
                        <option selected value=""></option>
                        <!--INICIO ITERACION DE CADA ELEMENTO DE LA LISTA DE CATEGORIAS-->
                        <c:forEach var="categoria" items="${categorias}">
                            <option value="${categoria.idCategoria}">${categoria.nombreCategoria}</option>
                        </c:forEach><!--FIN ITERACION DE CADA ELEMENTO DE LA LISTA DE CATEGORIAS-->
                    </select>
                </div>
                
                <div>
                    <label for="imagen">Imagen</label>
                    <input type="file" id="imagen" name="imagen" class="block-100" required value="producto.imagen">
                </div>
    
                <div class="cont-registro">
                    <button type="submit" class="boton-transparente btn-crear"><i class="fa-solid fa-dragon"></i> Guardar Informacion</button>
                </div>
            </form>
        </div>
    </div>
</div>

<jsp:include page="../WEB-INF/templates/footer_user.jsp"/>