/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




var poligogoTO;
var poligonoSeleccionado;
var arrayPoligonosSeleccionados;
var pathsTemp;
var arrayPathsTemp;
var pathsTemp;
var arrayIndicesPoligonos;
var indicesPoligonos;
var estatus = null;
var mapPoligonos;
var cMapaId;
var zoom = 10;
var listenerdblClickMapa;
var listenerClickMapa;

function inicializarDatos(indices, idMapa, zoomParam) {
    indicesPoligonos = indices;
    cMapaId = idMapa;
    var mapa = PF('' + cMapaId).getMap();
    arrayPoligonosSeleccionados = [];
    if (indices.length > 0) {
        arrayIndicesPoligonos = indices.split(",");

        for (var idx in arrayIndicesPoligonos) {
//            mapa.polygons[arrayIndicesPoligonos[idx]].setDraggable(true);
//            mapa.polygons[arrayIndicesPoligonos[idx]].setEditable(true);
            poligogoTO = new Object();
            poligonoSeleccionado = mapa.polygons[arrayIndicesPoligonos[idx]];
            poligogoTO.poligono = poligonoSeleccionado;
            poligogoTO.pathsTemp = poligonoSeleccionado.getPath().getArray().slice();
            poligogoTO.indice = arrayIndicesPoligonos[idx];
            arrayPoligonosSeleccionados.push(poligogoTO);
        }
    }
    poligonoSeleccionado = null;
    arrayPathsTemp = [];
    poligonoSeleccionado = null;
    pathsTemp = null;
    zoom = zoomParam;

    listenerdblClickMapa = mapa.addListener('dblclick', function () {
        terminarAgregarPoligono();
    });
}

function terminarAgregarPoligono() {
    if (estatus === 'NUEVO') {
        google.maps.event.removeListener(listenerClickMapa);
    }
}

function agregarPoligono() {
    terminarAgregarPoligono();
    estatus = 'NUEVO';
    var mapa = PF('' + cMapaId).getMap();
    pathsTemp = [];
//    mapa.addListener('dblclick', agregarLatLngPoligono);
    poligonoSeleccionado = new google.maps.Polygon({
        paths: pathsTemp,
        strokeColor: '#000000',
        strokeOpacity: 1.0,
        strokeWeight: 3
    });
    poligonoSeleccionado.setEditable(true);
    poligonoSeleccionado.setDraggable(true);
    poligonoSeleccionado.setMap(mapa);

    poligogoTO = new Object();
    poligogoTO.poligono = poligonoSeleccionado;
    poligogoTO.pathsTemp = poligonoSeleccionado.getPath();
    poligogoTO.indice = -1;
    arrayPoligonosSeleccionados.push(poligogoTO);
    listenerClickMapa = mapa.addListener('click', agregarLatLngPoligono);
}

function editarPoligonos() {
    estatus = 'EDITAR';
    var mapa = PF('' + cMapaId).getMap();

    for (var idx in arrayPoligonosSeleccionados) {
        mapa.polygons[arrayPoligonosSeleccionados[idx].indice].setDraggable(true);
        mapa.polygons[arrayPoligonosSeleccionados[idx].indice].setEditable(true);
    }

    if (arrayPoligonosSeleccionados.length > 0) {
        estatus = 'EDITAR';
//        try {
//            mapa.setCenter((new google.maps.LatLng(arrayPoligonosSeleccionados[0].poligono.pathsTemp[0].lat(), arrayPoligonosSeleccionados[0].poligono.pathsTemp[0].lng())));
//            mapa.setZoom(zoom);
//        } catch (exception) {
//            console.log('Error habilitarEdicionPoligono:' + exception);
//        }
    } else {
        alert('No existe cartografía del predio por favor trazela en el mapa');
        estatus = 'NINGUNA';
    }
}

function cancelarTrazoPoligono() {
    if (estatus === 'EDITAR') {
        cancelarEdicionPoligono();
    } else if (estatus === 'NUEVO') {
        cancelarNuevoPoligono();
    }
//    estatus = 'NINGUNA';
}

function cancelarEdicionPoligono() {
    var mapa = PF('' + cMapaId).getMap();
    for (var idx in arrayPoligonosSeleccionados) {
        mapa.polygons[arrayPoligonosSeleccionados[idx].indice].setDraggable(false);
        mapa.polygons[arrayPoligonosSeleccionados[idx].indice].setEditable(false);
        mapa.polygons[arrayPoligonosSeleccionados[idx].indice].setPath(arrayPoligonosSeleccionados[idx].pathsTemp);
    }
}



function cancelarNuevoPoligono() {
    if (poligonoSeleccionado !== null) {
        try {
            poligonoSeleccionado.setDraggable(false);
            poligonoSeleccionado.setEditable(false);
            poligonoSeleccionado.setMap(null);
            poligonoSeleccionado = null;
            pathsTemp = null;
        } catch (exception) {
            console.log('Error cancelarNuevoPoligono' + exception);
        }
    }
}


function agregarLatLngPoligono(event) {
    try {
        if (poligonoSeleccionado !== null) {
//                            console.log('existe poligon');
            pathsTemp.push(event.latLng);
//                            console.log('lat mar:' + event.latLng);
//                            console.log('puntosRuta :' + puntosRuta);
            if (poligonoSeleccionado.getPath() === undefined) {
//                                console.log('Sin paths');
                poligonoSeleccionado.setPath(pathsTemp);
            } else {
//                                console.log('Cn paths:' + poligono.getPath());
//                                console.log('Cn paths:' + poligono.getPath().getArray());
                var pathPologono = poligonoSeleccionado.getPath().getArray();
                pathPologono.push(event.latLng);
                poligonoSeleccionado.setPath(pathPologono);
                poligonoSeleccionado.setEditable(true);

            }
        }
    } catch (error) {
        console.log(error);
    }
}

function transformarCoordenadasMultipoligono(idInput) {
    var mapa = PF('' + cMapaId).getMap();
    for (var idx in arrayPoligonosSeleccionados) {
        var poligonoSeleccionadoTO = arrayPoligonosSeleccionados[idx];
//        if (poligonoSeleccionadoTO.indice === -1) {
        if (poligonoSeleccionadoTO.poligono.getMap !== null) {
//        if (poligonoSeleccionadoTO.poligono.getMap !== null && poligonoSeleccionadoTO.poligono.getPath().getArray().length > 0) {
            if (poligonoSeleccionadoTO.poligono !== null && validarPoligono(poligonoSeleccionadoTO.poligono) === false) {
                alert('Los Poligonos deben contener minimo 3 vertices');
                return;
            }
        }
//        }
    }

    var multipoligonos = new Array();

    for (var idx in arrayPoligonosSeleccionados) {
        var poligonoTO = arrayPoligonosSeleccionados[idx];
//        if (poligonoTO.indice === -1) {

        if (poligonoTO.poligono.getMap !== null && poligonoTO.poligono.getPath() !== undefined && poligonoTO.poligono.getPath() !== null
                && poligonoTO.poligono.getPath().getArray() !== undefined && poligonoTO.poligono.getPath().getArray().length > 2) {
//        if (poligonoTO.poligono.getMap !== null && poligonoTO.poligono.getPath().getArray().length > 2) {
            multipoligonos.push(poligonoTO.poligono.getPath().getArray());
        }
//        } else {
//            multipoligonos.push(poligonoTO.poligono.getPath().getArray());
//        }
    }
    document.getElementById('' + idInput).value = JSON.stringify(multipoligonos);
    guardarDatosMultipoligono();
}
//function transformarCoordenadasMultipoligono(idInput) {
//    var mapa = PF('' + cMapaId).getMap();
//    for (var idx in arrayPoligonosSeleccionados) {
//        var poligonoSeleccionadoTO = arrayPoligonosSeleccionados[idx];
//        if (poligonoSeleccionadoTO.indice === -1)
//            if (poligonoSeleccionadoTO.poligono.getMap !== null && poligonoSeleccionadoTO.poligono.getPath().getArray().length > 0) {
//                if (poligonoSeleccionadoTO.poligono !== null && validarPoligono(poligonoSeleccionadoTO.poligono) === false) {
//                    alert('Los Poligonos deben contener minimo 3 vertices');
//                    return;
//                }
//                break;
//            }
//    }
//
//    var multipoligonos = new Array();
//
//    for (var idx in arrayPoligonosSeleccionados) {
//        var poligonoTO = arrayPoligonosSeleccionados[idx];
//        if (poligonoTO.indice === -1) {
//            if (poligonoTO.poligono.getMap !== null && poligonoTO.poligono.getPath().getArray().length > 2) {
//                multipoligonos.push(poligonoTO.poligono.getPath().getArray());
//            }
//        } else {
//            multipoligonos.push(poligonoTO.poligono.getPath().getArray());
//        }
//    }
//    console.log('JSON.stringify(multipoligonos:' + JSON.stringify(multipoligonos));
//    document.getElementById('' + idInput).value = JSON.stringify(multipoligonos);
//    guardarDatosMultipoligono();
//}

//function DeleteMenu() {
//    this.div_ = document.createElement('div');
//    this.div_.className = 'delete-menu';
//    this.div_.innerHTML = 'Delete';
//
//    var menu = this;
//    google.maps.event.addDomListener(this.div_, 'rightclick', function () {
////    google.maps.event.addDomListener(this.div_, 'click', function () {
//        menu.removeVertex();
//    });
//}
//DeleteMenu.prototype = new google.maps.OverlayView();
//
//DeleteMenu.prototype.onAdd = function () {
//    var deleteMenu = this;
//    var map = this.getMap();
//    this.getPanes().floatPane.appendChild(this.div_);
//
//    // mousedown anywhere on the map except on the menu div will close the
//    // menu.
//    this.divListener_ = google.maps.event.addDomListener(map.getDiv(), 'mousedown', function (e) {
//        if (e.target !== deleteMenu.div_) {
//            deleteMenu.close();
//        }
//    }, true);
//};
//
//DeleteMenu.prototype.onRemove = function () {
//    google.maps.event.removeListener(this.divListener_);
//    this.div_.parentNode.removeChild(this.div_);
//
//    // clean up
//    this.set('position');
//    this.set('path');
//    this.set('vertex');
//};
//
//DeleteMenu.prototype.close = function () {
//    this.setMap(null);
//};
//
//DeleteMenu.prototype.draw = function () {
//    var position = this.get('position');
//    var projection = this.getProjection();
//
//    if (!position || !projection) {
//        return;
//    }
//
//    var point = projection.fromLatLngToDivPixel(position);
//    this.div_.style.top = point.y + 'px';
//    this.div_.style.left = point.x + 'px';
//};
//
///**
// * Opens the menu at a vertex of a given path.
// */
//DeleteMenu.prototype.open = function (map, path, vertex) {
//    this.set('position', path.getAt(vertex));
//    this.set('path', path);
//    this.set('vertex', vertex);
//    this.setMap(map);
//    this.draw();
//};
//
///**
// * Deletes the vertex from the path.
// */
//DeleteMenu.prototype.removeVertex = function () {
//    var path = this.get('path');
//    var vertex = this.get('vertex');
//
//    if (!path || vertex === undefined) {
//        this.close();
//        return;
//    }
//
//    path.removeAt(vertex);
//    this.close();
//};
//
