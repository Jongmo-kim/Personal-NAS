import { fetchJson } from "@/apis/apiConfig"

const getTest = async () => {
    const res = await fetchJson('/test/greeting');
    return await res.text();
}

export {
    getTest,
}
