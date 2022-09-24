import { fetchJson } from "@/apis/apiConfig"

const getTest = async () => {
    const res = await fetchJson('/');
    return await res.text();
}

export {
    getTest,
}
