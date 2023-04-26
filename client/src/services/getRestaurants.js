import useSWR from 'swr'
import { useRouter } from 'next/router'
const fetcher = (...args) => fetch(...args).then((res) => res.json())

export default function getRestaurants() {
  const router = useRouter()
  const { category } = router.query

  let params = ''
  if (category)
    params = `${params == '' ? '?' : '&'}category=${category}`

  const { data, error } = useSWR(
    `${process.env.apiUrl}/api/restaurants${params}`,
    fetcher, {
    revalidateOnFocus: false
  }
  )

  return { restaurants: data, isLoading: !error && !data, isError: error }
}