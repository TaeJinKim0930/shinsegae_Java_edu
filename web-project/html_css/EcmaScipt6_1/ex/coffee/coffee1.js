export let name = "Americanoo";

let coffee = {
    getName : function () {
        return name;
    },

    setName : function (newName) {
        name = newName;
    }
}

export default coffee;
