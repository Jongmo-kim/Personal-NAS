import { fetchJson } from "@/apis/apiConfig";



const select = async () => {
    const param = {
    };
    const opt = {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(param)
    }
    const res = await fetchJson('/api/members', opt);
    return await res.text();
}

const insert = async (id,password,name) => {
    const param = {
        id,
        password,
        name
    };
  
    const res = await fetchJson('/api/members', 'POST', param);
    return res;
}

export {
    select,
    insert,
}
