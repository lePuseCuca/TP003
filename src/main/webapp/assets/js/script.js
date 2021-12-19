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

const $tipoSelect = document.querySelector('#tipo');
const $tipoPromoSelect = document.querySelector('#tipo-promocion');
const $checkContainer = document.querySelector('#check-container');
const $atraccionesCheck = document.querySelectorAll('.form-check-input');
const $promoEspecialValue = document.querySelectorAll('[data-tipo-promo]');
const $promoEspecialContainer = document.querySelectorAll('.tipo-promo');

//Object.keys(atracciones).forEach(key => {
//    $checkContainer.appendChild(createCheckItem(key));    
//});

$tipoSelect.addEventListener('change', (e) => {
    $atraccionesCheck.forEach(element => {
        element.checked = false;
        (element.dataset.tipoAtr == e.target.value) ? element.disabled = false : element.disabled = true;
    });
})

$tipoPromoSelect.addEventListener('change', (e) => {
    console.log(e.target.value);
    $promoEspecialContainer.forEach(element => {
        element.checked = false;
        (element.dataset.tipoPromo == e.target.value) ? element.children[1].disabled = false : element.children[1].disabled = true;
    });
})