import DetailsRestaurant from "@/components/DetailsRestaurant"

export default function Restaurant({restaurant}) {
  return <DetailsRestaurant restaurant={restaurant} />
}

export async function getStaticPaths() {
  const res = await fetch(`${process.env.apiUrl}/api/restaurants`)
  const restaurant = await res.json()

  const paths = restaurant.map((restaurant) => ({
    params: { id: restaurant.id.toString() }
  }))

  return { paths, fallback: false }
}

export async function getStaticProps({ params }) {
  const res = await fetch(`${process.env.apiUrl}/api/restaurants/${params.id}`)
  const restaurant = await res.json()

  return {
    props: { restaurant },
    revalidate: 120
  }
}