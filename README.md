Esta práctica consiste en la programación, siguiendo el patrón repositorio y MVVM, de una aplicación simple de gestión de módulos de FP. 

La aplicación permitirá registrar módulos de FP en una base de datos. Cada registro de la tabla almacenará un id numérico automático, un nombre y la cantidad de créditos.

En la misma pantalla se mostrará, en tiempo real, los datos que se van añadiendo a la base datos. 

La lista debe implementarse mediante un ListAdapter. Podéis partir de un Recycler Adapter, cuando funcione hacer un commit para que os quede para consulta propia, y posteriormente pasarlo a ListAdapter. 

En la captura, para envolver cada item se ha usado una Card de Material 3, con estillo Filled. Podéis intentarlo de ese modo aunque en este ejercicio no se trata tanto de los que se ve, sino de lo que se hace.

El botón Limpiar mostrará un DialogAlert solicitando confirmación. Si se confirma, se borrarán todos los registros de la tabla. 
