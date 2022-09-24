import { fetchJson } from "@/apis/apiConfig"

const getTest = async () => {
    return await fetchJson('/api/members');
}

export {
    getTest,
}
