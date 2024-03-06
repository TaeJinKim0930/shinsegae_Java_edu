let names = "홍길동";
let age = "10";
let dep = "교동초등학교";

let member = {
    getName : (() => {
        return names;
    }),
    
    setName : ((newName) => {
        names = newName;
    }),
    
    getAge : (() => {
        return age;
    }),
    
    setAge : ((newAge) => {
        age = newAge;
    }),
    
    getDep : (() => {
        return dep;
    }),
    
    setDep : ((newDep) => {
        dep = newDep;
    })
    
}

export {names, age, dep, member};
// export default member;