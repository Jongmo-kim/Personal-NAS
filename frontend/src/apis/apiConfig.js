
export const BASE_URL = 'http://localhost:9090';
export const fetchJson = (url, opt) => {
    opt = {
        ...opt,
    }
    return fetch(url, opt);
}