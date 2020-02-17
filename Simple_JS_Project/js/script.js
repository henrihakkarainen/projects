/*
 * Arvotaan ensimmäiset kolme maata. Maat, joilla on alle 2 naapurimaata
 * jätetään pois ensimmäisistä valinnoista.
 */
function firstThree() {
    if (array != null) {
        countryObjects = JSON.parse(array);
        let countries = _.filter(countryObjects, function (obj) {
            return (obj.borders.length > 2)
        });
        let threeRandom = _.sample(countries, 3);
        let newBlock = "";
        for (let i = 0; i < threeRandom.length; i++) {
            let c = threeRandom[i];
            newBlock += "<div class=\"country country0\"><span class=\"flag-icon flag-icon-"
                + c.alpha2Code.toLowerCase() + "\"></span><p><span>" + c.name + ":</span> " + c.capital +
                "</p><p><span>Currency:<br></span> " + c.currencies[0].name + " ("
                + c.currencies[0].code + ")</p><p><span>Borders:</span> "
                + c.borders.join(", ") + "</p></div>";
        }
        createNewTier(newBlock);
    }
}

/*
 * Luodaan DOM-puuhun seuraava taso.
 */
function createNewTier(content) {
    let nextLevelElem = document.createElement('h3');
    nextLevelElem.textContent = "Tier " + tier;
    let tierNum = "tier" + tier;
    nextLevelElem.classList.add(tierNum)
    tierElem.appendChild(nextLevelElem);
    let newTierElem = document.createElement('div');
    newTierElem.classList.add("tierBox");
    newTierElem.classList.add(tierNum);
    newTierElem.innerHTML = content;
    tierElem.appendChild(newTierElem);
    //let countryTier = ".country" + (tier);
    tier += 1;
    let countryElem = document.querySelectorAll(".country");
    for (let i = 0; i < countryElem.length; i++) {
        countryElem[i].addEventListener('click', nextTier);
    }
}

/*
 * Luodaan seuraava taso kohdemaita. Valitaan ainoastaan sellaiset
 * naapurimaat, joita ei ole aiemmilla tasoilla valittu.
 */
function nextTier() {
    // Otetaan talteen käyttäjän valitsema maa.
    let n = this.textContent.indexOf(": ");
    let countryName = this.textContent.substring(0, n);
    country = _.filter(countryObjects, function (obj) {
        return (obj.name == countryName)
    });

    let activeElemList = document.querySelectorAll(".active");
    this.classList.add("active");
    let currentElem = this.getAttribute("class");
    let reset = false;

    // Jos on aktiivisia maaruutuja, katsotaan kohdistuuko uusi valinta tasolle
    // jossa ollaan jo valittu maa vai uudelle tasolle.
    for (let i = 0; i < activeElemList.length; i++) {
        let activeElem = activeElemList[i];
        if (activeElem.getAttribute("class") == currentElem) {
            reset = true;
            let tierNr = activeElem.classList[1];
            tierNr = parseInt(tierNr[tierNr.length - 1]);
            if (activeElem.textContent != this.textContent) {
                activeElem.classList.remove("active");
            }
            resetTree(tierNr);
            choosedCountries.push(country);
            abbrList.push(country[0].alpha3Code);
            updateVisitList();
        }
    }
    if (!reset) {
        choosedCountries.push(country);
        abbrList.push(country[0].alpha3Code);
        updateVisitList();
    }
    // Tuodaan matkan yhteenvedon mahdollistava painike näkyviin, jos matka
    // sisältää vähintään kahdessa maassa vierailun.
    if (choosedCountries.length >= 2) {
        summaryBtn.hidden = false;
    }
    else {
        summaryBtn.hidden = true;
    }

    let neighbours = _.filter(countryObjects, function (obj) {
        return (obj.borders.includes(country[0].alpha3Code))
    });
    for (let i = 0; i < choosedCountries.length; i++) {
        neighbours = _.difference(neighbours, choosedCountries[i]);
    }
    // Käymättömiä naapurimaita löytyy vielä.
    if (neighbours.length > 0) {
        let classTier = "country" + tier;
        let newBlock = "";
        for (let i = 0; i < neighbours.length; i++) {
            let c = neighbours[i];
            newBlock += "<div class=\"country " + classTier + "\"><span class=\"flag-icon flag-icon-"
                + c.alpha2Code.toLowerCase() + "\"></span><p><span>" + c.name
                + ":</span> " + c.capital + "</p><p><span>Currency:<br></span> "
                + c.currencies[0].name + " (" + c.currencies[0].code
                + ")</p><p><span>Borders:</span> " + c.borders.join(", ")
                + "</p></div>";
        }
        createNewTier(newBlock);
    }
    // Kaikissa naapurimaissa on jo vierailtu.
    else {
        let nextLevelElem = document.createElement('h3');
        nextLevelElem.textContent = "No more tiers possible";
        tierElem.appendChild(nextLevelElem);
        let tierNum = "tier" + tier;
        nextLevelElem.classList.add(tierNum)
        summaryBtn.hidden = false;
    }

}
/*
 * Jos muuttaa alemmalla tasolla tehtyä valintaa, niin pyyhitään kaikki tasot
 * siitä alaspäin pois.
 */
function resetTree(currentTier) {
    let counter = 0;
    for (let i = currentTier; i < tier; i++) {
        let removableTiers = document.querySelectorAll(".tier" + (tier - counter));
        for (let j = 0; j < removableTiers.length; j++) {
            let removeTierElem = removableTiers[j];
            tierElem.removeChild(removeTierElem);
        }
        counter++;
    }
    // Poistetaan valittujen maiden listalta alemmilla tasoilla tehdyt valinnat.
    choosedCountries.length = currentTier;
    // Päivitetään reitti matkan koosteeseen.
    resetItinerary(currentTier);
    tier = currentTier + 1;
}

function resetItinerary(currentTier) {
    let counter = 0;
    for (let i = currentTier; i < tier; i++) {
        let removableSpans = document.querySelectorAll(".span" + (tier-counter-1));
        let removableBrs = document.querySelectorAll(".br" + (tier-counter-1));
        for (let j = 0; j < removableSpans.length; j++) {
            let removeSpanItem = removableSpans[j];
            let removeBrItem = removableBrs[j];
            abbrElem.removeChild(removeSpanItem);
            abbrElem.removeChild(removeBrItem);
        }
        counter++;
    }
    abbrList.length = currentTier;
    idx = currentTier;
}

/*
 * Tarkistetaan input-kentästä onko käyttäjän syöttämä nimi oikeellinen.
 * Jos nimi on ok, niin Submit-painikkeesta tulee painettava.
 */
function checkInput() {
    let inputOk = true;
    if (inputElem.validity.patternMismatch || inputElem.value == "") {
        inputOk = false;
    }
    submitBtn.disabled = !inputOk;
}

/*
 * Submit-painiketta painettaessa talletetaan matkaajan nimi matkareitti-palkin
 * ensimmäiseksi tiedoksi ja piilotetaan sivulta nimen kyselykenttä ja tuodaan
 * näkyville itse ohjelma.
 */
function submit() {
    let containerElem = document.querySelector("div.container");
    let travelerNameElem = document.querySelector("div.travelerName");
    let nameTagElem = document.createElement('div');
    let hrElem = document.createElement('hr');
    // innerHTML-elementin käyttö tässä varmaan ok, koska inputElem.value ei voi
    // sisältää muuta, paitsi kirjaimia väliltä a-z ja A-Z.
    nameTagElem.innerHTML = "<p><b>Matkaajan nimi:</b><br>" + inputElem.value
        + "</p><b>Matkareitti:<b>";
    abbrElem.appendChild(hrElem);
    abbrElem.appendChild(nameTagElem);
    containerElem.hidden = false;
    travelerNameElem.hidden = true;
}

/*
 * Lisätään maan lyhenne matkareitti-palkkiin listalle seuraavaksi.
 */
function updateVisitList() {
    let brElem = document.createElement('br');
    let spanElem = document.createElement('span');
    spanElem.textContent = abbrList[idx++];
    spanElem.setAttribute("class", "span" + (tier-1));
    brElem.setAttribute("class", "br" + (tier-1));
    abbrElem.appendChild(spanElem);
    abbrElem.appendChild(brElem);
}

function showSummary() {
    let containerElem = document.querySelector("div.container");
    let summaryElem = document.querySelector("div.summary");
    summaryElem.hidden = false;
    containerElem.hidden = true;
    let content = "";
    for (let i=0; i<choosedCountries.length; i++) {
        let toVisit = choosedCountries[i];
        let languages = new Array();
        for (let j=0; j<toVisit[0].languages.length; j++) {
            let l = toVisit[0].languages[j].name;
            languages.push(l);
        }
        content += "<h3>Country #" + (i+1) + "</h3><div class=\"toVisit\"><span class=\"flag-icon flag-icon-"
                    + toVisit[0].alpha2Code.toLowerCase() + "\"></span><h2>" + toVisit[0].name
                    + "</h2><p><span>Capital: </span>" + toVisit[0].capital + "</p><p><span>"
                    + "Region: </span>" + toVisit[0].region + "</p><p><span>Currency: </span>"
                    + toVisit[0].currencies[0].name + " (" + toVisit[0].currencies[0].code
                    + ")</p><p><span>Population: </span>" + toVisit[0].population + "</p><p>"
                    + "<span>Languages: </span>" + languages.join(", ") + "</p></div>";
    }
    createSummaryBlock(content);
}

function createSummaryBlock(content) {
    let customerNameEl = document.getElementById("customer");
    customerNameEl.textContent = "Name: " + inputElem.value;
    let parentDivEl = document.querySelector(".countryList");
    parentDivEl.innerHTML = content;
    window.scrollTo(0,0);
}

let dataSource = "https://restcountries.eu/rest/v2/all";

let xhr = new XMLHttpRequest();
let array;
let tier = 0;

xhr.onreadystatechange = function () {
    if (xhr.readyState == 4) {
        if (xhr.status == 200) {
            array = xhr.responseText;
            firstThree();
        }
        else {
            console.log("FAIL: " + xhr.statusText);
        }
    }
}

xhr.open("GET", dataSource, true);
xhr.send();

let tierElem = document.getElementById("tiers");
let abbrElem = document.getElementById("abbrList");
let abbrList = new Array();
let countryObjects;
let choosedCountries = new Array();

let inputElem = document.getElementById("input");
let submitBtn = document.getElementById("submitbutton");
let summaryBtn = document.getElementById("finished");
let idx = 0;

inputElem.addEventListener('input', checkInput);
submitBtn.addEventListener('click', submit);
summaryBtn.addEventListener('click', showSummary);

/*
 * Palestine, State of - alpha3Code: PSE, borders: [ISR, EGY, JOR]
 * Israel, Egypt, Jordan - borders: [..., SYR]
 * 
 * Ohjelmassa siis maalle "Palestine, state of" ei löydy koskaan naapurimaita,
 * koska tietokannassa sen alpha3Code ei ole sama kuin sen naapurimailla kyseisen
 * maan borders-koodi.
 */