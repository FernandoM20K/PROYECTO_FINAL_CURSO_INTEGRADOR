<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../WEB-INF/templates/header_user.jsp"/>
<jsp:include page="../WEB-INF/templates/dashboard.jsp"/>

<div class="contenedord">
    <div class="titulo">
        <h4>Lista de Productos</h4>
    </div>
    <div class="informacion notas">
        <div class="funciones-profesor">
            <div class="mensaje-export">
                <a href="${pageContext.request.contextPath}/ControladorProducto?accion=agregar" class="boton-verde-radio-inline"><i class="fa-solid fa-user-plus"></i><h6>Agregar Producto</h6></a>
            </div>
            
            <h6>Total de Registros: ${totalProductos}</h6>
        </div>

        <div class="tabla t-profesores">
            <table>
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Descripcion</th>
                        <th>Stock</th>
                        <th>Imagen</th>
                        <th>Categoria</th>
                        <th>Opcion</th>
                    </tr>
                </thead>
                <tbody>
                    <!--INICIO ITERACION DE CADA ELEMENTO DE LA LISTA DE PRODUCTOS-->
                    <c:forEach var="producto" items="${productos}">
                        <tr>
                            <td>${producto.idProducto}</td>
                            <td>${producto.descripcion}</td>
                            <td>${producto.stock}</td>
                            <td>${producto.imagen}</td>
                            <td>${producto.nombreCategoria}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/ControladorProducto?accion=editar&idProducto=${producto.idProducto}" class="boton-yellowgreen-radio-inline">
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