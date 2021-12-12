const atracciones = {
    "Moria": {
        "costo": 10,
        "tiempo": 2,
        "cupo": 6,
        "tipo": "AVENTURA"
    },
    "Minas Tirith": {
        "costo": 5,
        "tiempo": 2.5,
        "cupo": 25,
        "tipo": "PAISAJE"
    },

    "La Comarca": {
        "costo": 3,
        "tiempo": 6.5,
        "cupo": 150,
        "tipo": "DEGUSTACION"
    },

    "Mordor": {
        "costo": 25,
        "tiempo": 3,
        "cupo": 4,
        "tipo": "AVENTURA"
    },

    "Abismo de Helm": {
        "costo": 5,
        "tiempo": 2,
        "cupo": 15,
        "tipo": "PAISAJE"
    },
    "Lothlorien": {
        "costo": 35,
        "tiempo": 1,
        "cupo": 30,
        "tipo": "DEGUSTACION"
    },

    "Erebor": {
        "costo": 12,
        "tiempo": 3,
        "cupo": 32,
        "tipo": "PAISAJE"
    },

    "Bosque Negro": {
        "costo": 3,
        "tiempo": 4,
        "cupo": 12,
        "tipo": "AVENTURA"
    }
}

const $atraccionesContainer = document.querySelector('#atracciones');

function createAtraccion(atraccion) {
    const $atraccion = document.createElement('div');
    $atraccion.className = 'col-lg-3 col-md-6 col-sm-12';
    $atraccion.innerHTML = `
    <div class="card text-center">
        <div class="bg-image hover-overlay ripple" data-mdb-ripple-color="light">
            <img src="imgs/${atraccion.replace(" ", "_").replace(" ", "_")}.jpg" class="img-fluid" />
            <a href="#!">
                <div class="mask" style="background-color: rgba(251, 251, 251, 0.15)"></div>
            </a>
            
        </div>
        <div class="card-header"><span class="badge rounded-pill pill-${atracciones[atraccion].tipo.substr(0, 3).toLocaleLowerCase()}">${atracciones[atraccion].tipo}</span></div>
        <div class="card-body">
            <h5 class="card-title">${atraccion}</h5>
            <p class="card-text">
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Error vel in nisi magnam neque ducimus sapiente aliquam pariatur nostrum ab?
            </p>
            <div style="font-size: 1.2rem;">
            <span class="badge bg-info"><i class="fas fa-coins"></i> $ ${atracciones[atraccion].costo}</span>
            <span class="badge bg-info"><i class="fas fa-clock"></i> ${atracciones[atraccion].tiempo} hs.</span>
            <a href="#" ><span class="badge bg-success">COMPRAR</span></a>
            <!--button type="button" href="#" class="btn btn-success"
                                data-mdb-ripple-color="dark">
                                <i class="fas fa-shopping-cart"></i>
                            </button-->
            </div>
            <!--button type="button" class="btn btn-info btn-lg"><i class="fas fa-coins"></i> $ ${atracciones[atraccion].costo}</button>
            <button type="button" class="btn btn-info btn-lg"><i class="fas fa-clock"></i> ${atracciones[atraccion].tiempo} hs.</button-->    
        </div>
    </div>
    `;
    return $atraccion;
}

Object.keys(atracciones).forEach(key => {
    $atraccionesContainer.appendChild(createAtraccion(key));
});

function loadAtracciones() {

}
/* 
<div class="col-lg-3 col-md-6 col-sm-12">
                    <div class="card text-center ">
                        <div class="bg-image hover-overlay ripple" data-mdb-ripple-color="light">
                            <img src="https://mdbootstrap.com/img/new/standard/nature/111.jpg" class="img-fluid" />
                            <a href="#!">
                                <div class="mask" style="background-color: rgba(251, 251, 251, 0.15)"></div>
                            </a>
                        </div>
                        <div class="card-header"><span class="badge rounded-pill pill-ave">Aventura</span></div>
                        <div class="card-body">
                            <h5 class="card-title">Bosque Negro</h5>
                            <p class="card-text">
                                Lorem ipsum dolor sit amet consectetur adipisicing elit. Error vel in nisi magnam neque ducimus sapiente aliquam pariatur nostrum ab?
                            </p>
                            <button type="button" class="btn btn-info"><i class="fas fa-info"></i></button>
                            <button type="button" class="btn btn-success"><i class="fas fa-shopping-cart"></i></button>
                        </div>
                    </div>
                </div>
*/


// document.querySelector('#itinerario').addEventListener('click', function () {
//     document.querySelector("main").classList.toggle("hidden");
//     document.querySelector("#itinerario-container").classList.toggle("hidden");
// });

const sequencyCount = (arr) => {
    let count = 0;
    let max = 0;
    for (let i = 0; i < arr.length; i++) {
        if (arr[i] == arr[i + 1]) {
            count++;

        } else {
            if (count > max) {
                max = ++count;

            }
            count = 0;
        }
    }
    return max;
};

console.log(sequencyCount([true, true, true, true, true, false, true, true, true, true, true, true, false, false, false]))