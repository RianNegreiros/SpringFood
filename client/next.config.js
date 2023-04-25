/** @type {import('next').NextConfig} */
const nextConfig = {
  reactStrictMode: true,
}

module.exports = nextConfig

module.exports = {
  images: {
    domains: ['localhost'],
  },
  env: {
    apiUrl: 'http://localhost:3000',
  },
}