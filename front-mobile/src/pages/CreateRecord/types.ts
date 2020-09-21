import { GamePlatform } from "../../components/PlatformCard/types";

export type Game = {
    id: number,
    title: string,
    platform: GamePlatform,
    label: string,
    value: number
}

export type Interviewee = {
    name: string,
    age: string
}