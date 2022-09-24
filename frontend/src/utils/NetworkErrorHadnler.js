const errHandler = async (err) => {
    const errJson = await err.json();
    console.log(Object.keys(errJson));
    const errMsg = Object.keys(errJson).map(msg => {
        console.log(errJson[msg]);
        return errJson[msg];
    }).join('\n');
    console.log(errMsg);
    alert(errMsg);
}


export {
    errHandler
};