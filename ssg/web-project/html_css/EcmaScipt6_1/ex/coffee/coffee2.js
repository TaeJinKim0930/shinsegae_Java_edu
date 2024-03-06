let name = "Americanoo";

let getCoffee = function () {
    return name.toUpperCase();
};

let setCoffee = function (newName) {
    name = newName;
};

export {name, getCoffee, setCoffee};
